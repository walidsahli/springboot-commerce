package com.project.commerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commerce.Models.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
