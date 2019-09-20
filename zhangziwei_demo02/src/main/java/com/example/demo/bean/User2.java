package com.example.demo.bean;


public class User2 {

	private int id;
	private String name;
	private String sex;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User2(int id, String name, String sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + "]";
	}

	
}

