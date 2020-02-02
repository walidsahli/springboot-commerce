package com.project.commerce.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.commerce.Models.Entities.Role;
import com.project.commerce.Models.Utils.EnumRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(EnumRole name);
}
