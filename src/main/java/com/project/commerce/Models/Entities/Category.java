package com.project.commerce.Models.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	@NotNull
	private String name;
	
	
	public Category(String name) {
		this.name = name;
	}
	public Category() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	
}
