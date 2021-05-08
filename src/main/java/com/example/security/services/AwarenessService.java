package com.example.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Awareness;
import com.example.repository.AwarenessRepository;

@Service
public class AwarenessService {
	
	@Autowired
	AwarenessRepository awarenessRepository;
	
	
	//GET ALL AWARENESS
	 public List<Awareness> getAware() { List<Awareness> Aware = new ArrayList<>();
	  awarenessRepository.findAll().forEach(Aware::add); return Aware; }
	 
	 //ADD AWARENESS INFO
	 public Awareness addAware(Awareness aware) {
		 return awarenessRepository.save(aware);
	 }

	 //DELETE AWARENESS INFO
	 public void deleteAware(Long id) {
		 awarenessRepository.deleteById(id);
	 }

}
