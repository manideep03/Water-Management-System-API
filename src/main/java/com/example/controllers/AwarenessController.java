package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Awareness;
import com.example.security.services.AwarenessService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AwarenessController {
	
	
	@Autowired
	AwarenessService awarenessService;
	
	
	//GET ALL AWARENESS
	@GetMapping("/getAwareness")
	public List<Awareness> getAware()
	{
		return awarenessService.getAware();
	}


	//ADD WATER INFORMATION
	@PostMapping("/addAwareness")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public List<String> addAware(@RequestBody Awareness aware) {
		awarenessService.addAware(aware);

		return List.of("water added");
	}

	//DELETE AWARENESS INFO BY ID
	@DeleteMapping("/deleteAwareness/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public String deleteAware(@PathVariable Long id) {
		awarenessService.deleteAware(id);
		return "Delete water";
	}		
}
