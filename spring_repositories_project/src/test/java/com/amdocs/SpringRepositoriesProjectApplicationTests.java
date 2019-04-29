package com.amdocs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amdocs.models.Todo;
import com.amdocs.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRepositoriesProjectApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRepositoriesProjectApplicationTests.class);
	
	@Autowired
	private TodoService todoService;
	
	@Test
	public void contextLoads() {
		LOGGER.info("test Started");
		List<Todo> todos = todoService.retriveAllTodos();
		assertEquals(new Integer(0), new Integer(todos.size()));
		
		LOGGER.info("test ended");
	}

}
