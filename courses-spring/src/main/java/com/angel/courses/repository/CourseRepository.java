package com.angel.courses.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.angel.courses.domain.Course;

public interface CourseRepository {

	Course getCourseById(@Param("id") Long id);
	
	List<Course> getAll();
	
	Long insert(Course course);
	
	List<Course> getAllActive();
}
