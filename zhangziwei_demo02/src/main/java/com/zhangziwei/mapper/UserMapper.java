package com.zhangziwei.mapper;

import java.util.List;
import java.util.Map;

import com.zhangziwei.bean.Type;
import com.zhangziwei.bean.User;

/**
 * @作者: 张紫薇
 * @时间:2019年10月9日上午9:32:59
 * 
 */
public interface UserMapper {

	List<Map<String, Object>> getUserList(Map<String, Object> map);

	int count();

	List<Type> selectType();

	int addUser(User user);

	int addType(Map<String, Object> map);

	void delAll(String uids);

}
