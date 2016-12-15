package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.capgemini.chess.bo.TodoBO;
import com.capgemini.chess.dao.TodoDao;
import com.capgemini.chess.mapper.TodoMapper;
import com.capgemini.chess.service.TodoService;
import com.capgemini.chess.to.TodoTO;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoDao todoDao;

	@Override
	public TodoTO getTask(Long id) {
		return TodoMapper.map(todoDao.getOne(id));
	}

	@Override
	public List<TodoTO> getAllTasks() {
		return TodoMapper.map2TOs(todoDao.findAll());
	}

	@Override
	@Transactional
	public TodoTO saveTask(TodoTO todoTO) {
		return TodoMapper.map(todoDao.save(TodoMapper.map(todoTO)));
	}

	@Override
	@Transactional
	public TodoTO updateTask(TodoTO updates) {
		TodoBO todo = todoDao.getOne(updates.getId());
		updateTodo(updates, todo);
		return TodoMapper.map(todoDao.update(todo));
	}

	private void updateTodo(TodoTO updates, TodoBO todo) {
		todo.setCategory(updates.getCategory());
		todo.setTitle(updates.getTitle());
		todo.setPriority(updates.getPriority());
		todo.setContent(updates.getContent());
		if (updates.getDate() != null) {
			todo.setDate(updates.getDate());
		}
		todo.setStatus(updates.getStatus());
	}

}
