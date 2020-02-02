package com.project.commerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commerce.Models.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
