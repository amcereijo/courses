package com.angel.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.angel.courses.domain.Level;
import com.angel.courses.service.LevelService;


@RestController
@RequestMapping("/api/levels")
public class LevelsController {

	@Autowired
	private LevelService levelService;
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Level> get(){
		List<Level> levels = levelService.findAllLevels();
		
		return levels;
	}
}
