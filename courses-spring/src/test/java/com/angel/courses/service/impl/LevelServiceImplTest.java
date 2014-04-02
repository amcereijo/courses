package com.angel.courses.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.angel.courses.domain.Level;
import com.angel.courses.repository.LevelRespository;
import com.google.common.collect.Lists;


public class LevelServiceImplTest {

	@Mock
	private LevelRespository repository;
	
	private LevelServiceImpl service;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		service = new LevelServiceImpl();
		ReflectionTestUtils.setField(service, "repository", repository);
	}
	
	@Test
	public void testFindAllLevels(){
		List<Level> levels = Lists.newArrayList(
				new Level().setId(1L),
				new Level().setId(2L)
				);
		Mockito.when(repository.getAll()).thenReturn(levels);
		
		List<Level> levelsFind = service.findAllLevels();
		Assert.assertNotNull(levelsFind);
		Assert.assertTrue(levelsFind.size() == 2);
		
		Mockito.verify(repository, Mockito.times(1)).getAll();
		
	}
}
