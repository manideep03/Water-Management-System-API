package com.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.security.services.UserDetailsServiceImpl;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping("/admin/getAllUsers")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public List<Map<String, Object>> getAlUsers(){
		return userDetailsServiceImpl.getUsers();
	}
	
	//GET USER BY USER ID
	@GetMapping("/admin/getUser/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Optional<User> getbyId(@PathVariable Long id) {
		return userDetailsServiceImpl.findById(id);
	}
	
	//DELETE USER INFORMATION
	@DeleteMapping("/admin/deleteUser/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<String> deleteUser(@PathVariable Long id) {
		userDetailsServiceImpl.deleteUser(id);
		
		return List.of("user deleted");
	}


}
