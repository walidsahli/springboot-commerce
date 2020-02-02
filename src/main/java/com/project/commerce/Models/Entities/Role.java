package com.project.commerce.Models.Entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.project.commerce.Models.Utils.EnumRole;

@Entity(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EnumRole name;
	
	public Role() {}
	
	public Role(EnumRole name) {
		this.name = name;
	}
	
	public EnumRole getName() {
		return name;
	}

	public void setName(EnumRole name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

}
