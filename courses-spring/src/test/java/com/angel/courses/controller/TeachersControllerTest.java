package com.angel.courses.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.angel.courses.domain.Teacher;
import com.angel.courses.service.TeacherService;
import com.google.common.collect.Lists;

public class TeachersControllerTest {

	@Mock
	private TeacherService service;
	
	private TeachersController controller;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		controller = new TeachersController();
		ReflectionTestUtils.setField(controller, "teacherService", service);
	}
	
	@Test
	public void testGet(){
		List<Teacher> teachersMock = Lists.newArrayList(
				new Teacher().setId(1L),
				new Teacher().setId(2L)
				);
		Mockito.when(service.findAllTeachers()).thenReturn(teachersMock);
		
		List<Teacher> teachers = controller.get();
		Assert.assertNotNull(teachers);
		Assert.assertTrue(teachers.size() == 2);
		
		Mockito.verify(service, Mockito.times(1)).findAllTeachers();
	}
}
