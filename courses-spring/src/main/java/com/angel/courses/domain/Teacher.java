package com.angel.courses.domain;

import java.io.Serializable;

public class Teacher implements Serializable{

	private static final long serialVersionUID = -471251896665690711L;
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
