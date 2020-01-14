package com.project.commerce.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Length(max = 50, min = 3 ,message = "product name length must be between 3 to 50 caracteres")
	private String name;
	
	@NotNull(message = "price is required")
	private double price;
	
	@NotNull(message = "stock number is required")
	private int inStock;
	
	@NotNull(message = "category is required")
	@ManyToOne(fetch =FetchType.EAGER,optional = false)
	private Category category;
	
	
	public Product () {}
	
	public Product(String name, double price, int inStock, Category category) {
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.category = category;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	public Long getId() {
		return id;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}


}
