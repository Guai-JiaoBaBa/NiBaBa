package com.zhangziwei.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangziwei.bean.Movie;
import com.zhangziwei.bean.Type;
import com.zhangziwei.mapper.MovieMapper;
import com.zhangziwei.service.MovieService;

/**
 * @作者: 张紫薇
 * @时间:2019年10月9日下午1:49:20
 * 
 */
@Service
public class MovieServiceImpl implements MovieService{
	
	@Resource
	private MovieMapper movieMapper;

	@Override
	public List<Map<String, Object>> getMovieList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return movieMapper.getMovieList(map);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return movieMapper.count();
	}

	@Override
	public int delMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieMapper.delMovie(movie);
	}

	@Override
	public List<Type> getTypeList() {
		// TODO Auto-generated method stub
		return movieMapper.getTypeList();
	}

	@Override
	public int addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieMapper.addMovie(movie);
	}


	@Override
	public Movie getMovieById(Movie movie) {
		// TODO Auto-generated method stub
		return movieMapper.getMovieById(movie);
	}

	@Override
	public int addType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return movieMapper.addType(map);
	}

	@Override
	public int delType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return movieMapper.delType(map);
	}
	
}
