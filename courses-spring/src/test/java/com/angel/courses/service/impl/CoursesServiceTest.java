package com.angel.courses.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.angel.courses.domain.Course;
import com.angel.courses.domain.Level;
import com.angel.courses.domain.Teacher;
import com.angel.courses.repository.CourseRepository;
import com.google.common.collect.Lists;


public class CoursesServiceTest {
	
	private CoursesServiceImpl coursesService;
	@Mock
	private CourseRepository repository;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		coursesService = new CoursesServiceImpl();
		ReflectionTestUtils.setField(coursesService, "repository", repository);
	}
	
	@Test
	public void testFindAllCourses(){
		List<Course> courses = Lists.newArrayList(
				new Course().setId(1L),
				new Course().setId(2L));
		Mockito.when(repository.getAll()).thenReturn(courses);
		
		List<Course> coursesFind = coursesService.findAllCourses();
		
		Assert.assertNotNull(coursesFind);
		Assert.assertTrue(coursesFind.size() == 2);
		
		Mockito.verify(repository, Mockito.times(1)).getAll();
	}
	
	@Test
	public void testCreateNewCourse(){
		Long id = 1L;
		Mockito.when(repository.insert(Mockito.any(Course.class))).thenReturn(id);
		
		Course course = new Course()
			.setActive(Boolean.TRUE)
			.setHours(100)
			.setLevel(new Level().setId(1L))
			.setTeacher(new Teacher().setId(1L))
			.setTitle("Title");
		course = coursesService.createNewCourse(course);
		
		Assert.assertNotNull(course);
		Assert.assertNotNull(course.getId());
		
		Mockito.verify(repository, Mockito.times(1)).insert(Mockito.any(Course.class));
	}
}
