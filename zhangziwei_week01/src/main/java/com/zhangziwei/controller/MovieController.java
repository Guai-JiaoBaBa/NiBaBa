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

import com.zhangziwei.bean.Movie;
import com.zhangziwei.bean.Type;
import com.zhangziwei.service.MovieService;
import com.zhangziwei.utils.PageUtils;

/**
 * @作者: 张紫薇
 * @时间:2019年10月9日下午1:48:18
 * 
 */
@SuppressWarnings("all")
@Controller
public class MovieController {
	@Resource
	private MovieService movieService;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("test.do")
	public String test() {
		return "test";
		
	}
	//列表展示
	@RequestMapping("list.do")
	public String getMovieList(Model model,@RequestParam(defaultValue = "") String cpage) {
		//创建map
		Map<String,Object> map = new HashMap<>();
		//设置页数
		int pageSize = 3;
		//设置总页数
		int count = movieService.count();
		//创建工具类对象
		PageUtils pageUtils = new PageUtils(cpage, count, pageSize);
		int pageRecord = pageUtils.getPageRecord();
		int pageSize2 = pageUtils.getPageSize();
		map.put("pageRecord", pageRecord);
		map.put("pageSize2", pageSize2);
		List<Map<String,Object>> list = movieService.getMovieList(map);
		model.addAttribute("list", list);
		model.addAttribute("page", pageUtils.getPage());
		return "list";
		
	}
	
	//删除功能
	@RequestMapping("todel.do")
	public String todel(Movie movie,String[] tids) {
		movieService.delMovie(movie);
		Map<String,Object> map = new HashMap<>();
		map.put("tids", tids);
		map.put("mid", movie.getMid());
		movieService.delType(map);
		return "redirect:list.do";
		
	}
	//跳转添加
	@RequestMapping("toadd.do")
	public String toadd(Model model) {
		List<Type> typeList = new ArrayList<>();
		BoundListOperations ops = redisTemplate.boundListOps("getTypeList");
		List range = ops.range(0, -1);
		if( range.size() > 0 && range != null ) {
			typeList = range ;
		}else {
			typeList = movieService.getTypeList();
			for (Object obj : typeList) {
				ops.rightPush(obj);
				ops.expire(40, TimeUnit.SECONDS);
			}
		}
		model.addAttribute("typeList", typeList);
		return "addMovie";
		
	}
	//添加
	@RequestMapping("addMovie.do")
	@ResponseBody
	public int addMovie(Movie movie,String[] tids) {
		int addMovie = movieService.addMovie(movie);
		Map<String,Object> map = new HashMap<>();
		map.put("tids", tids);
		map.put("mid", movie.getMid());
		int addType = movieService.addType(map);
		return 1;
		
	}
	//修改
	@RequestMapping("toupd.do")
	public String toupd(Model model,Movie movie) {
		List<Type> typeList = movieService.getTypeList();
		model.addAttribute("typeList", typeList);
		Movie movieById = movieService.getMovieById(movie);
		model.addAttribute("movieById", movieById);
		return "updMovie";
	}
	

}
