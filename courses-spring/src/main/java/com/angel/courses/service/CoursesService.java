package com.angel.courses.service;

import java.util.List;

import com.angel.courses.domain.Course;

public interface CoursesService {

	List<Course> findAllCourses();
	
	List<Course> findAllActiveCourses(boolean active);
	
	Course createNewCourse(Course course);
}
