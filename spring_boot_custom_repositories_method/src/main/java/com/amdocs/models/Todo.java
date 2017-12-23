package com.amdocs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Amit
 *
 */
@Entity
@Table(name = "todos")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(name = "title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "description", length = 500, nullable = false)
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return title;
	}
	public void setName(String name) {
		this.title = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Todo(String id, String name, String description) {
		super();
		this.id = id;
		this.title = name;
		this.description = description;
	}
	public Todo() {
		super();
	}
	
}
