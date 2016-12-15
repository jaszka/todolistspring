package com.capgemini.chess.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chess.service.TodoService;
import com.capgemini.chess.to.TodoTO;
@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoRestService {

	@Autowired
	private TodoService todoService;

	@RequestMapping(params = "id", method = RequestMethod.GET)
	public TodoTO showTodoDetails(@RequestParam("id") Long todoId) {
		return todoService.getTask(todoId);
	}

	@RequestMapping(params = "update", method = RequestMethod.POST)
	public TodoTO updateTodo(@RequestBody TodoTO todoToUpdate) {
		return todoService.updateTask(todoToUpdate);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public TodoTO saveTodo(@RequestBody TodoTO todoToSave) {
		return todoService.saveTask(todoToSave);
	}

	@RequestMapping(params = "all", method = RequestMethod.GET)
	public List<TodoTO> showAllTodos() {
		return todoService.getAllTasks();
	}

}
