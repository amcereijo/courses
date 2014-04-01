package com.angel.courses.domain;

import java.io.Serializable;

public class Course implements Serializable{

	private static final long serialVersionUID = -5541950287954186477L;
	
	private Long id;
	private String title;
	private String level;
	private int hours;
	private boolean active;
	
	private Teacher teacher;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
