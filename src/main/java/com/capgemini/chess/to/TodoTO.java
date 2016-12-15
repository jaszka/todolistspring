package com.capgemini.chess.to;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.capgemini.chess.enums.Category;
import com.capgemini.chess.enums.Priority;
import com.capgemini.chess.enums.Status;

public class TodoTO {

	private Long id;
	private Category category;
	private String title;
	private Priority priority;
	private String content;
	private Timestamp date;
	private Timestamp addedAt;
	private Status status;

	public TodoTO() {
	}

	public TodoTO(Long id, Category category, String title, Priority priority, String content, Timestamp date, Status status) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.priority = priority;
		this.content = content;
		this.date = date;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Timestamp getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Timestamp addedAt) {
		this.addedAt = addedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
