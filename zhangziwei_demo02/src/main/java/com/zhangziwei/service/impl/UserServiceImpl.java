package com.zhangziwei.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangziwei.bean.Type;
import com.zhangziwei.bean.User;
import com.zhangziwei.mapper.UserMapper;
import com.zhangziwei.service.UserService;

/**
 * @作者: 张紫薇
 * @时间:2019年10月9日上午9:32:04
 * 
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;

	@Override
	public List<Map<String, Object>> getUserList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.getUserList(map);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return userMapper.count();
	}

	@Override
	public List<Type> selectType() {
		// TODO Auto-generated method stub
		return userMapper.selectType();
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	@Override
	public int addType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.addType(map);
	}

	@Override
	public void delAll(String uids) {
		// TODO Auto-generated method stub
		userMapper.delAll(uids);
	}

}
