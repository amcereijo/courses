package com.angel.courses.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.angel.courses.Application;
import com.angel.courses.config.DatabaseConfiguration;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {Application.class, DatabaseConfiguration.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
	DbUnitTestExecutionListener.class })
@DatabaseSetup("/data/coursesData.xml")
@DatabaseTearDown(type=DatabaseOperation.DELETE_ALL, value="/data/coursesData.xml")
public class CoursesApiTest {

	@Autowired
	protected WebApplicationContext webApplicationContext; 
	protected MockMvc mockMvc;
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testGet() throws Exception{
		mockMvc.perform(
			get("/api/courses")
				.contentType(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();
	}
	
	@Test
	public void testCreate() throws Exception{
		String content = "{\"title\":\"My first course\",\"level\":{\"id\":1,\"name\":\"Básico\"},\"hours\":10,\"active\":false,\"teacher\":{\"id\":1,\"name\":\"Básico\"}}";
		
		mockMvc.perform(
			post("/api/courses")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isCreated())
			.andReturn();
	}
}
