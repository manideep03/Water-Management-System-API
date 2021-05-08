package com.example.controllers;

import java.util.List;
import java.util.Map;

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

import com.example.models.Water;
import com.example.security.services.WaterService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WaterController {
	
	@Autowired
	private WaterService waterService;
	
	//GET ALL WATERS
	@GetMapping("/getAllWaters")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE') or  hasRole('ROLE_USER')")
	List<Map<String,Object>> getWaters(){
		return waterService.getWaters();
	}
	
	
	//GET WATER BY WATER ID
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("getWater/{id}")
	List<Map<String,Object>> getWater(@PathVariable Long id){
		return waterService.findByWid(id);
	}
	
	//GET WATER BY WATER USER ID
	@GetMapping("getWaterInfo/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public List<Map<String, Object>> getbyUid(@PathVariable Long id) {
		return waterService.findByUid(id);
	}
	
	
	//ADD WATER INFORMATION
	@PostMapping("/addInfo")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public List<String> addWater(@RequestBody Water water) {
		waterService.addWater(water);
		
		return List.of("water added");
	}
	
	
	//UPDATE WATER INFORMATION
	@PutMapping("/admin/{id}")
	///@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public String updateWater(@RequestBody Water water,@PathVariable Long id) {
		waterService.updateWater(id, water);
		return "Water Info Updated";
	}
	
	//DELETE WATER INFORMATION
	@DeleteMapping("/admin/deleteWater/{id}")
	///@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteWater(@PathVariable Long id) {
		waterService.deleteWater(id);
	}
	
	
}

