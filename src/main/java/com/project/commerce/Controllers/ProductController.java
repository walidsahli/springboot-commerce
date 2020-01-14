package com.project.commerce.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.commerce.Models.Product;
import com.project.commerce.Services.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Product>> getProducts () {
		List<Product> products = service.getAll();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping(path = "/{category_id}/new")
	public ResponseEntity<String> saveProduct(@RequestBody Product product,
											  @RequestParam(defaultValue = "1") Long cateogry_id) {
		service.save(product , cateogry_id);
		return ResponseEntity.ok("product created");
	}
}
