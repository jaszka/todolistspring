package com.capgemini.chess.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.bo.TodoBO;
import com.capgemini.chess.to.TodoTO;

public class TodoMapper {

	public static TodoTO map(TodoBO todoBO) {
		if (todoBO != null) {
			TodoTO todoTO = new TodoTO();
			todoTO.setId(todoBO.getId());
			todoTO.setCategory(todoBO.getCategory());
			todoTO.setTitle(todoBO.getTitle());
			todoTO.setPriority(todoBO.getPriority());
			todoTO.setContent(todoBO.getContent());
			todoTO.setDate(todoBO.getDate());
			todoTO.setAddedAt(todoBO.getCreatedAt());
			todoTO.setStatus(todoBO.getStatus());
			return todoTO;
		}
		return null;
	}
	
	public static TodoBO map(TodoTO todoTO) {
		if (todoTO != null) {
			TodoBO todoBO = new TodoBO();
			todoBO.setCategory(todoTO.getCategory());
			todoBO.setTitle(todoTO.getTitle());
			todoBO.setPriority(todoTO.getPriority());
			todoBO.setContent(todoTO.getContent());
			todoBO.setDate(todoTO.getDate());
			todoBO.setStatus(todoTO.getStatus());
			return todoBO;
		}
		return null;
	}

	public static List<TodoTO> map2TOs(List<TodoBO> todoBOs) {
		return todoBOs.stream().map(TodoMapper::map).collect(Collectors.toList());
	}
	
	public static List<TodoBO> map2BOs(List<TodoTO> todoTOs) {
		return todoTOs.stream().map(TodoMapper::map).collect(Collectors.toList());
	}


}
