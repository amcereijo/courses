package com.angel.courses.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.angel.courses.domain.Level;
import com.angel.courses.service.LevelService;
import com.google.common.collect.Lists;

public class LevelsControllerTest {

	@Mock
	private LevelService service;
	
	private LevelsController controller;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		controller = new LevelsController();
		ReflectionTestUtils.setField(controller, "levelService", service);
	}
	
	@Test
	public void testGet(){
		List<Level> levelsMock = Lists.newArrayList(
				new Level().setId(1L),
				new Level().setId(2L)
				);
		Mockito.when(service.findAllLevels()).thenReturn(levelsMock);
		
		List<Level> levels = controller.get();
		Assert.assertNotNull(levels);
		Assert.assertTrue(levels.size() == 2);
		
		Mockito.verify(service, Mockito.times(1)).findAllLevels();
	}
}
