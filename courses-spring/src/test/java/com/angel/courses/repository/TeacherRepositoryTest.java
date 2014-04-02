package com.angel.courses.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.angel.courses.config.DatabaseTestConfiguration;
import com.angel.courses.domain.Teacher;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseTestConfiguration.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
	DbUnitTestExecutionListener.class })
@DatabaseSetup("/data/teachersData.xml")
@DatabaseTearDown(type=DatabaseOperation.DELETE_ALL, value="/data/teachersData.xml")

public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void testGetAll(){
		List<Teacher> teachers = teacherRepository.getAll();
		Assert.assertNotNull(teachers);
		Assert.assertTrue(teachers.size() == 3);
	}
}
