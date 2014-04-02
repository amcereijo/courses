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
import com.angel.courses.domain.Level;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfiguration.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
	DbUnitTestExecutionListener.class })
@DatabaseSetup("/data/levelsData.xml")
@DatabaseTearDown(type=DatabaseOperation.DELETE_ALL, value="/data/levelsData.xml")
public class LevelRespositoryTest {

	@Autowired
	private LevelRespository levelRespository;
	
	@Test
	public void testGetAll(){
		List<Level> levels = levelRespository.getAll();
		Assert.assertNotNull(levels);
		Assert.assertTrue(levels.size() == 3);
	}
}
