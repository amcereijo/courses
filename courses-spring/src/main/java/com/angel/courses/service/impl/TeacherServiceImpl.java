package com.angel.courses.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.courses.domain.Teacher;
import com.angel.courses.repository.TeacherRepository;
import com.angel.courses.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	@Override
	public List<Teacher> findAllTeachers() {
		return repository.getAll();
	}

}
