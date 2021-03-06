package com.angel.courses.domain;

import java.io.Serializable;

public class Teacher implements Serializable{

	private static final long serialVersionUID = -471251896665690711L;
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public Teacher setId(Long id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Teacher setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
	
	
}
