package com.capgemini.chess.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.bo.TodoBO;
import com.capgemini.chess.dao.TodoDao;

@Repository
public class TodoDaoImpl extends AbstractDao<TodoBO, Long> implements TodoDao {

}
