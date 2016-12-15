package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.to.TodoTO;

public interface TodoService {
	
	public TodoTO getTask(Long id);
	
	public List<TodoTO> getAllTasks();
	
	public TodoTO saveTask(TodoTO todoTO);
	
	public TodoTO updateTask(TodoTO updates);

}
