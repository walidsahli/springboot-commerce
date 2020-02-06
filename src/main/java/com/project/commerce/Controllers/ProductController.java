package com.project.commerce.Controllers;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.commerce.Models.Entities.Product;
import com.project.commerce.Services.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping(path = "/all")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<List<Product>> getProducts () {
		List<Product> products = service.getAll();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping(path = "/{category_id}/new")
	public ResponseEntity<String> saveProduct( Product product,
											  @RequestParam(defaultValue = "1") Long cateogry_id,
											  @RequestParam("file") MultipartFile file) throws FileUploadException {
		service.save(product , cateogry_id ,file);
		return ResponseEntity.ok("product created");
	}
}
