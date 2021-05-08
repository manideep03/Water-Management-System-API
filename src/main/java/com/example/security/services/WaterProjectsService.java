package com.example.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.WaterProjects;
import com.example.repository.WaterProjectsRepository;

@Service
public class WaterProjectsService {
	
	@Autowired
	private WaterProjectsRepository waterProjectsRepository;
	
	
	//LIST ALL PROJECTS
	public List<WaterProjects> getProjects() {
		List<WaterProjects> projects = new ArrayList<>();
		waterProjectsRepository.findAll().forEach(projects::add);
		return projects;
	}
	
	
	//GET WATER BY WATERProject BY PROJECT ID
	public Optional<WaterProjects> findById(Long id) {
		return waterProjectsRepository.findById(id);
	}

	
	//To add new projects
	public WaterProjects addProject(WaterProjects waterProjects) {
		return waterProjectsRepository.save(waterProjects);
	}
	
	//to update projects
	public String updateProjects(Long id,WaterProjects waterProjects) {
		waterProjectsRepository.save(waterProjects);
		
		return "project information updated";
	}
	
	
	//DELETE Project by id
	public String deleteProject(Long id) {
		waterProjectsRepository.deleteById(id);
		return "project information deleted";
	}
	
}
