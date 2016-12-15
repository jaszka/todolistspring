package com.capgemini.chess.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.chess.enums.Category;
import com.capgemini.chess.enums.Priority;
import com.capgemini.chess.enums.Status;
import com.capgemini.chess.service.TodoService;
import com.capgemini.chess.to.TodoTO;
import com.capgemini.chess.utils.FileUtils;

public class TodoRestServiceTest {

	@InjectMocks
	private TodoRestService todoRestService;
	@Mock
	private TodoService todoService;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(todoRestService).build();
	}

	@Test
	public void shouldShowTodo() throws Exception {
		// given
		final Long id = 1L;
		TodoTO todo = new TodoTO(1L, Category.MEETING, "Title", Priority.HIGH, "content", new Timestamp(System.currentTimeMillis()), Status.DONE);
		Mockito.when(todoRestService.showTodoDetails(Mockito.any())).thenReturn(todo);
		// when
		ResultActions response = this.mockMvc.perform(get("/todos?id=" + id));
		// then
		response.andExpect(status().isOk())//
				.andExpect(MockMvcResultMatchers.jsonPath("$.category").value(todo.getCategory().toString()));
	}
	
	@Test
	public void shouldShowAllTodos() throws Exception {
		// given
		// when
		ResultActions response = this.mockMvc.perform(get("/todos?all="));
		// then
		response.andExpect(status().isOk());
	}


}
