package com.angel.courses.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.courses.domain.Level;
import com.angel.courses.repository.LevelRespository;
import com.angel.courses.service.LevelService;

@Service
public class LevelServiceImpl implements LevelService{
	
	@Autowired
	private LevelRespository repository;
	
	@Override
	public List<Level> findAllLevels() {
		return repository.getAll();
	}
}
