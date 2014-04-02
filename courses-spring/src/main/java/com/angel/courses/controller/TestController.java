package com.angel.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angel.courses.repository.CourseRepository;


@Controller
public class TestController {

	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello Courses!";
    }

}
