package com.example.demo.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.bawei.common.utils.StringUtil;
import com.example.demo.bean.User;
import com.example.demo.bean.User2;

@Controller
public class UserController {
	
	@Resource
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired(required = false)
	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		RedisSerializer<?> stringRedisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setValueSerializer(stringRedisSerializer);
		redisTemplate.setHashKeySerializer(stringRedisSerializer);
		redisTemplate.setHashValueSerializer(stringRedisSerializer);
		this.redisTemplate = redisTemplate;
	}
	
	@RequestMapping("testJDKRedis")
	public String testJDKRedis() throws UnsupportedEncodingException {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		
		long pre = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			String name = StringUtil.randomChineseString(3);
			Long randomLong = StringUtil.randomLong(0, 1);
			String sex = null;
			if(randomLong/2%2==0) {
				sex = "男";
						
			}else {
				sex = "女";
			}
			String phone = StringUtil.randomLong(134, 8)+"";
			User user = new User(i, name, sex, phone);
			operations.set(i+"", user.toString());
		}
		long next = System.currentTimeMillis();
		System.out.println("序列化时间为:"+(next-pre));
		return "";
	}
	
	@RequestMapping("testJSONRedis")
	public String testJSONRedis() throws UnsupportedEncodingException {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		long pre = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			String name = StringUtil.randomChineseString(3);
			Long randomLong = StringUtil.randomLong(0, 1);
			String sex = null;
			if(randomLong/2%2==0) {
				sex = "男";
			}else {
				sex = "女";
			}
			String phone = StringUtil.randomLong(134, 8)+"";
			User2 user = new User2(i,name,sex,phone);
			Object json = JSON.toJSON(user);
			operations.set(i+"", json+"");
			
		}
		long next = System.currentTimeMillis();
		System.out.println("序列化时间为:"+(next-pre));
		return "";
	}
	@RequestMapping("testHashRedis")
	public String testHashRedis() throws UnsupportedEncodingException {
		HashOperations<String, Object, Object> operations = redisTemplate.opsForHash();
		long pre = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			String name = StringUtil.randomChineseString(3);
			Long randomLong = StringUtil.randomLong(0, 1);
			String sex = null;
			if(randomLong/2%2==0) {
				sex = "男";
			}else {
				sex = "女";
			}
			String phone = StringUtil.randomLong(134, 8)+"";
			User2 user = new User2(i,name,sex,phone);
			operations.put("hash"+i, i+"", user.toString());
		}
		long next = System.currentTimeMillis();
		System.out.println("序列化时间为:"+(next-pre));
		return "";
	}

}
