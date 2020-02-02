package com.project.commerce.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.commerce.Models.Entities.Category;
import com.project.commerce.Repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repo;
	
	public Category save(Category category) {
		return repo.save(category);
	}
	
	public List<Category> getAll(){
		return repo.findAll();
	}
}
