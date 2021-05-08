package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.WaterProjects;

@Repository
public interface WaterProjectsRepository extends JpaRepository<WaterProjects, Long>{
	
	Optional<WaterProjects> findById(Long id);
	
	
}
