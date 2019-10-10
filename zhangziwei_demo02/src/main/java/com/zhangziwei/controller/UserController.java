package com.zhangziwei.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhangziwei.bean.Type;
import com.zhangziwei.bean.User;
import com.zhangziwei.service.UserService;
import com.zhangziwei.utils.PageUtils;

/**
 * @作者: 张紫薇
 * @时间:2019年10月9日上午9:15:07
 * 
 */
@SuppressWarnings("all")
@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	@Autowired
	private RedisTemplate redisTemplate;
	//
	@RequestMapping("test.do")
	public String test() {
		return "test";
		
	}
	
	//列表展示
	@RequestMapping("list.do")
	public String getUserList(Model model,
			@RequestParam(defaultValue="") String cpage
			) {
		//创建map
		Map<String,Object> map = new HashMap<String,Object>();
		//每页的数据
		int pageSize = 3;
		//总页数
		int count = userService.count();
		//创建工具类
		PageUtils pageUtils = new PageUtils(cpage, count, pageSize);
		int pageRecord = pageUtils.getPageRecord();
		int pageSize2 = pageUtils.getPageSize();
		map.put("pageRecord", pageRecord);
		map.put("pageSize2", pageSize2);
		List<Map<String,Object>> list = userService.getUserList(map);
		model.addAttribute("list", list);
		model.addAttribute("page", pageUtils.getPage());
		return "list";
	}
	
	//跳转添加页面
		@RequestMapping("toadd.do")
		public String toadd(Model model) {
			BoundListOperations listOps = redisTemplate.boundListOps("selectType");
			List range = listOps.range(0, -1);
			List<Type> listType = new ArrayList<>();
			if(range.size() > 0 && range != null) {
				listType = range;
			}else {	
				listType =  userService.selectType();
				for (Object obj : listType) {
					listOps.rightPush(obj);
					listOps.expire(3, TimeUnit.SECONDS);
				}
			}
			model.addAttribute("listType", listType);
			return "addUser";
			
		}
		
		//添加
		@RequestMapping("addUser.do")
		public String addUser(User user,String[] tids) {
			userService.addUser(user);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("tids", tids);
			map.put("uid", user.getUid());
			int i = userService.addType(map);
			return "redirect:list.do";
		}
		//批量删除
		@RequestMapping("todelAll.do")
		@ResponseBody
		public boolean todelAll(String uids) {
			userService.delAll(uids);
			System.out.println("88888888888888888888"+uids);
			return true;
		}

}
