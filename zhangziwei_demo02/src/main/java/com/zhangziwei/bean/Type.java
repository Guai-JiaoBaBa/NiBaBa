package com.zhangziwei.bean;

import java.io.Serializable;

/**
 * @作者: 张紫薇
 * @时间:2019年10月9日上午11:09:57
 * 
 */
@SuppressWarnings("all")
public class Type implements Serializable{
	
	private int tid;
	private String tname;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	

}
