package com.project.commerce.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.commerce.Models.Entities.Category;
import com.project.commerce.Services.CategoryService;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@PostMapping(path = "/new")
	public Category save(@RequestBody @Valid Category category) {
		return service.save(category);
	}
	
	@GetMapping(path = "/all")
	public List<Category> getAll(){
		return service.getAll(); 
	}
}
