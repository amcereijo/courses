package com.angel.courses.repository;

import org.apache.ibatis.annotations.Param;

import com.angel.courses.domain.Course;

public interface CourseRepository {

//	@Select("SELECT * FROM courses WHERE id = #{id}")
	Course getCourseById(@Param("id") Long id);
}
