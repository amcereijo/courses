package com.angel.courses.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.angel.courses.domain.Teacher;
import com.angel.courses.repository.TeacherRepository;
import com.google.common.collect.Lists;

public class TeacherServiceImplTest {

	@Mock
	private TeacherRepository repository;
	
	private TeacherServiceImpl service;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		service = new TeacherServiceImpl();
		ReflectionTestUtils.setField(service, "repository", repository);
	}
	
	@Test
	public void testFindAll(){
		List<Teacher> teachers = Lists.newArrayList(
				new Teacher().setId(1L),
				new Teacher().setId(2L)
			);
		Mockito.when(repository.getAll()).thenReturn(teachers);
		
		List<Teacher> teachersFind = service.findAllTeachers();
		
		Assert.assertNotNull(teachersFind);
		Assert.assertTrue(teachersFind.size() == 2);
		
		Mockito.verify(repository, Mockito.times(1)).getAll();
		
		
	}
}
