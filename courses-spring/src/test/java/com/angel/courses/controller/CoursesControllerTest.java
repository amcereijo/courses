package com.angel.courses.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.angel.courses.domain.Course;
import com.angel.courses.domain.Level;
import com.angel.courses.domain.Teacher;
import com.angel.courses.service.CoursesService;
import com.google.common.collect.Lists;

public class CoursesControllerTest {

	@Mock
	private CoursesService service;
	
	private CoursesController controller;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		controller = new CoursesController();
		ReflectionTestUtils.setField(controller, "coursesService", service);
	}
	
	@Test
	public void testGet(){
		List<Course> courses = Lists.newArrayList(
				new Course().setId(1L),
				new Course().setId(2L)
				);
		Mockito.when(service.findAllCourses()).thenReturn(courses);
		
		List<Course> courseGet = controller.get(null);
		Assert.assertNotNull(courseGet);
		Assert.assertTrue(courseGet.size() == 2);
		
		Mockito.verify(service, Mockito.times(1)).findAllCourses();
	}
	
	@Test
	public void testGetActive(){
		List<Course> courses = Lists.newArrayList(
				new Course().setId(1L),
				new Course().setId(2L)
				);
		Mockito.when(service.findAllActiveCourses(Boolean.TRUE)).thenReturn(courses);
		
		List<Course> courseGet = controller.get(Boolean.TRUE);
		Assert.assertNotNull(courseGet);
		Assert.assertTrue(courseGet.size() == 2);
		
		Mockito.verify(service, Mockito.times(1)).findAllActiveCourses(Boolean.TRUE);
	}
	
	@Test
	public void testGetDeActive(){
		List<Course> courses = Lists.newArrayList(
				new Course().setId(1L),
				new Course().setId(2L)
				);
		Mockito.when(service.findAllActiveCourses(Boolean.FALSE)).thenReturn(courses);
		
		List<Course> courseGet = controller.get(Boolean.FALSE);
		Assert.assertNotNull(courseGet);
		Assert.assertTrue(courseGet.size() == 2);
		
		Mockito.verify(service, Mockito.times(1)).findAllActiveCourses(Boolean.FALSE);
	}
	
	
	@Test
	public void create(){
		Course courseMock = new Course()
			.setActive(Boolean.TRUE)
			.setHours(20)
			.setLevel(new Level().setId(1L))
			.setTeacher(new Teacher().setId(2L))
			.setTitle("Title")
			.setId(1L);
		Mockito.when(service.createNewCourse(Mockito.any(Course.class))).thenReturn(courseMock);
		
		Course course = new Course()
			.setActive(Boolean.TRUE)
			.setHours(20)
			.setLevel(new Level().setId(1L))
			.setTeacher(new Teacher().setId(2L))
			.setTitle("Title");
		
		ResponseEntity<Object> result = (ResponseEntity<Object>)controller.create(course);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getStatusCode() == HttpStatus.CREATED); 
		
		Mockito.verify(service, Mockito.times(1)).createNewCourse(Mockito.any(Course.class));
	}
}
