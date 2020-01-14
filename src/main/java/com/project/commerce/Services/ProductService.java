package com.project.commerce.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.commerce.Models.Category;
import com.project.commerce.Models.Product;
import com.project.commerce.Repositories.CategoryRepository;
import com.project.commerce.Repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	
	public List<Product> getAll(){
		return productRepo.findAll();
	}
	
	public Product save(Product product, Long cateogry_id) {
		Category category = categoryRepo.getOne(cateogry_id);
		product.setCategory(category);
		return productRepo.save(product);
	}
}
