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

import com.angel.courses.config.DatabaseConfiguration;
import com.angel.courses.domain.Course;
import com.angel.courses.domain.Level;
import com.angel.courses.domain.Teacher;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfiguration.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
	DbUnitTestExecutionListener.class })

@DatabaseSetup("/data/coursesData.xml")
@DatabaseTearDown(type=DatabaseOperation.DELETE_ALL, value="/data/coursesData.xml")
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	
	@Test
	public void testGetAll(){
		List<Course> courses = courseRepository.getAll();
		Assert.assertTrue(courses.size() == 3);
	}
	
	@Test
	public void testGetAllActive(){
		List<Course> courses = courseRepository.getAllActive();
		Assert.assertTrue(courses.size() == 2);
	}
	
	@Test
	public void testGetCourseById(){
		Course course = courseRepository.getCourseById(1L);
		Assert.assertNotNull(course);
	}
	
	@Test
	public void testInsert(){
		Course course = new Course()
			.setActive(Boolean.TRUE)
			.setHours(100)
			.setLevel(new Level().setId(1L))
			.setTeacher(new Teacher().setId(1L))
			.setTitle("Title");
		
		Long id = courseRepository.insert(course);
		
		Assert.assertNotNull(course);
		Assert.assertNotNull(id);
		
	}
}
