package com.angel.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.angel.courses.domain.Course;
import com.angel.courses.service.CoursesService;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

	@Autowired
	private CoursesService coursesService;
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> get(){
		List<Course> courses = coursesService.findAllCourses();
		
		return courses;
	}
	
	
	@ResponseStatus(value=HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Object> create(@RequestBody Course course){
		//TODO valid
		coursesService.createNewCourse(course);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
}
