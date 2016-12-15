package com.capgemini.chess.bo;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.capgemini.chess.enums.Category;
import com.capgemini.chess.enums.Priority;
import com.capgemini.chess.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "todos")
public class TodoBO extends AbstractTimestampBO {

	private static final long serialVersionUID = 1840372478654976124L;

	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(nullable = false)
	private String title;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	private String content;
	@Column(columnDefinition = "datetime")
	private Timestamp dateRequired;
	@Enumerated(EnumType.STRING)
	private Status status;

	public TodoBO() {
	}

	public TodoBO(Category category, String title, Priority priority, String content, Timestamp dateRequired, Status status) {
		super();
		this.category = category;
		this.title = title;
		this.priority = priority;
		this.content = content;
		this.dateRequired = dateRequired;
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return dateRequired;
	}

	public void setDate(Timestamp dateRequired) {
		this.dateRequired = dateRequired;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
