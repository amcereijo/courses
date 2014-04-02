package com.angel.courses.domain;

import java.io.Serializable;

public class Course implements Serializable{

	private static final long serialVersionUID = -5541950287954186477L;
	
	private Long id;
	private String title;
	private Level level;
	private int hours;
	private boolean active;
	private Teacher teacher;
	
	public Course setId(Long id) {
		this.id = id;
		return this;
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Course setTitle(String title) {
		this.title = title;
		return this;
	}
	public Level getLevel() {
		return level;
	}
	public Course setLevel(Level level) {
		this.level = level;
		return this;
	}
	public int getHours() {
		return hours;
	}
	public Course setHours(int hours) {
		this.hours = hours;
		return this;
	}
	public boolean isActive() {
		return active;
	}
	public Course setActive(boolean active) {
		this.active = active;
		return this;
	}
	public Course setTeacher(Teacher teacher) {
		this.teacher = teacher;
		return this;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", level=" + level
				+ ", hours=" + hours + ", active=" + active + ", teacher="
				+ teacher + "]";
	}
	
	
}
