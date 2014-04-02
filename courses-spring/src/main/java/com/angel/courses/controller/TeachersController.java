package com.angel.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.angel.courses.domain.Teacher;
import com.angel.courses.service.TeacherService;


@RestController
@RequestMapping("/api/teachers")
public class TeachersController {

	@Autowired
	private TeacherService teacherService;
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Teacher> get(){
		List<Teacher> teachers = teacherService.findAllTeachers();
		return teachers;
	}
	
}
