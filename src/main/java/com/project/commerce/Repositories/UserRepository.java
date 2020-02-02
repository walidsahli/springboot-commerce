package com.project.commerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commerce.Models.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
