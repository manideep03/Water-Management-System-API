package com.example.security.services;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Water;
import com.example.repository.WaterRepository;

@Service
public class WaterService {
	
	@Autowired
	private WaterRepository waterRepository;
	
	
	//LIST ALL WATERS
	
	/*
	 * public List<Water> getWaters() { List<Water> waters = new ArrayList<>();
	 * waterRepository.findAll().forEach(waters::add); return waters; }
	 */
	 
	/*
	 * public ResponseEntity<?> getWaters() { List<Water> waters = new
	 * ArrayList<>(); waterRepository.findAll() .forEach(waters::add); return
	 * ResponseEntity.ok(new WaterResponse(null, null, null, null, null), null,
	 * null, null, null)); }
	 */
	
	//test
	
	public List<Map<String,Object>> getwaterinfo(Long id){
		return waterRepository.getwaterinfo(id);
	}
	
	//Get ALL WATER LIST
	public List<Map<String,Object>> getWaters(){
		return waterRepository.getWaters();
	}
	
	//Get WATER BY CITY
	
	public List<Map<String,Object>> findbyCity(String city){
		return waterRepository.findbyCity(city);
	}
	
	//GET WATER BY WATER ID
	 public List<Map<String, Object>> findByWid(Long id) { 
		 return waterRepository.findByWid(id);
	 }
	
	//
	 
	
	
	//GET WATER BY WATER USER ID
	public List<Map<String,Object>> findByUid(Long id) {
		return waterRepository.findByUid(id);
	}
	
	
	//SAVE NEW WATER INSTANCE
	public Water addWater(Water water) {
		return waterRepository.save(water);
	}
	
	//UPDATE WATER BY WATER ID
	public void updateWater(Long id,Water water) {
		waterRepository.save(water);
	}
	
	
	//DELETE WATER BY WATER ID
	public void deleteWater(Long id) {
		waterRepository.deleteById(id);
	}

	
	
	

}

