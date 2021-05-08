
package com.example.controllers;
  
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.security.services.UserDetailsServiceImpl;
  
  
@CrossOrigin(origins = "*", maxAge = 3600)
  
@RestController
  
@RequestMapping("/") 
public class TestController {
	
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@GetMapping("/all")
	public List<String> allAccess() {
		return List.of("public content");
	}
  
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_ADMIN')")
	public String userAccess() { return "User Content."; }
  
  
	@GetMapping("/emp")
	@PreAuthorize("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_ADMIN')")
	public String moderatorAccess() {
		return "employee Board."; }
  
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() { return
			"Admin Board."; }
  
	  @GetMapping("/admin/users")
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  public String adminUserAccesss() { 
		  return "Admin Block";
		  }
	  
	  @PostMapping("/logout/done")
	  public String logout() {
		  
		  
		  return "success";
	  }
	 
  
	  
}
 
  
 