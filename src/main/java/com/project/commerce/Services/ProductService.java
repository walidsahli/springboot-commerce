package com.project.commerce.Services;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.commerce.Models.Entities.Category;
import com.project.commerce.Models.Entities.Product;
import com.project.commerce.Repositories.CategoryRepository;
import com.project.commerce.Repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	UploadService uploadService;
	
	public List<Product> getAll(){
		return productRepo.findAll();
	}
	
	public String save(Product product, Long cateogry_id ,MultipartFile file) throws FileUploadException {
		uploadService.uploadFile(file);
		System.out.println(file.getName());
		// Category category = categoryRepo.getOne(cateogry_id);
		// product.setCategory(category);
		// return productRepo.save(product);
		return "true";
	}
}
