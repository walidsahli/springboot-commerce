package com.project.commerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commerce.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
