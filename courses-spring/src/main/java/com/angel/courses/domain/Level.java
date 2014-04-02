package com.angel.courses.domain;

import java.io.Serializable;

public class Level implements Serializable{

	private static final long serialVersionUID = -6059520837153174476L;
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public Level setId(Long id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Level setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public String toString() {
		return "Level [id=" + id + ", name=" + name + "]";
	}
	
	
}
