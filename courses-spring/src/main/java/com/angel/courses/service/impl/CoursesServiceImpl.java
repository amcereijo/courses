package com.angel.courses.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.courses.domain.Course;
import com.angel.courses.repository.CourseRepository;
import com.angel.courses.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	private CourseRepository repository;
	
	@Override
	public List<Course> findAllCourses() {
		List<Course> courses = repository.getAll();
		return courses;
	}

	@Override
	public Course createNewCourse(Course course) {
		Long id = repository.insert(course);
		course.setId(id);
		return course;
	}

}
