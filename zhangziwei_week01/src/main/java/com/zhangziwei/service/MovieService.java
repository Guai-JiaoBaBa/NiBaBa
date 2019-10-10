package com.zhangziwei.service;

import java.util.List;
import java.util.Map;

import com.zhangziwei.bean.Movie;
import com.zhangziwei.bean.Type;

/**
 * @作者: 张紫薇
 * @时间:2019年10月9日下午1:49:05
 * 
 */
public interface MovieService {

	List<Map<String,Object>> getMovieList(Map<String, Object> map);

	int count();

	int delMovie(Movie movie);

	List<Type> getTypeList();

	int addMovie(Movie movie);

	int addType(Map<String, Object> map);

	Movie getMovieById(Movie movie);

	int delType(Map<String, Object> map);



}
