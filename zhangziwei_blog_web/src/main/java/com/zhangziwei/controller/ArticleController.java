package com.zhangziwei.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangziwei.pojo.Article;
import com.zhangziwei.service.ArticleService;

/**
 * @作者:张紫薇
 * @时间:2019年9月19日上午8:32:17
 * 
 */
@RestController
public class ArticleController {
	
	@Reference
	
	private ArticleService articleService;

	
	@RequestMapping(value="/article/findAll",method=RequestMethod.GET)
	public List<Article> findAll(){
		return articleService.findAll();
	}
}
