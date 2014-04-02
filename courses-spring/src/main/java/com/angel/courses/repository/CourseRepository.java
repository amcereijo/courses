package com.angel.courses.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.angel.courses.domain.Course;

public interface CourseRepository {

//	@Select("SELECT * FROM courses WHERE id = #{id}")
	Course getCourseById(@Param("id") Long id);
	
	List<Course> getAll();
	
	Long insert(Course course);
}
