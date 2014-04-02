package com.angel.courses.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.angel.courses.Application;
import com.angel.courses.config.DatabaseTestConfiguration;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {Application.class, DatabaseTestConfiguration.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
	DbUnitTestExecutionListener.class })
@DatabaseSetup("/data/levelsData.xml")
@DatabaseTearDown(type=DatabaseOperation.DELETE_ALL, value="/data/levelsData.xml")
public class LevelsApiTest extends BaseApitTest{

	@Test
	public void testGet() throws Exception{
		mockMvc.perform(
			get("/api/levels")
				.contentType(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();
	}
}
