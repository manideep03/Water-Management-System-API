package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.WaterProjects;
import com.example.security.services.WaterProjectsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WaterProjectsController {
	
	
	@Autowired
	private WaterProjectsService waterProjectsService;
	
		@GetMapping("/getAllProjects")
		List<WaterProjects> getAllWaters()
		{
			return waterProjectsService.getProjects();
		}
		
		//ADD PROJECT INFORMATION
		@PostMapping("/admin/addProjectsInfo")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
		public void addProject(@RequestBody WaterProjects waterProjects) {
			waterProjectsService.addProject(waterProjects);
		}

		@GetMapping("/admin/getProjects/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
		public Optional<WaterProjects> findById(@PathVariable Long id) {
			return waterProjectsService.findById(id);
		}
	
		//UPDATE Project INFORMATION
		@PutMapping("/admin/updateProjects/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
		public void updateWater(@RequestBody WaterProjects waterProjects,@PathVariable Long id) {
			waterProjectsService.updateProjects(id, waterProjects);
		}
		
		//DELETE WATER INFORMATION
		@DeleteMapping("/admin/deleteProjects/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public void deleteProjects(@PathVariable Long id) {
			waterProjectsService.deleteProject(id);
		}
		

}
