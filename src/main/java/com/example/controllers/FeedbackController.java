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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Feedback;
import com.example.security.services.FeedbackService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedService;
	
	
	//SAVE NEW FEEDBACKS
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("addFeedback")
	public void savefeedback(@RequestBody Feedback feedback) {
		feedService.savefeedback(feedback);
	}
	
	
	//GET FEEDBACK BY WATER ID
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	@GetMapping("getFeedbackByWid/{id}")
	public List<Map<String,Object>> findbyWid(@PathVariable Long id) {
		return feedService.findbyWid(id);
	}
	
	// Get by User USER ID
	@GetMapping("getFeedback/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_USER')")
	public List<Map<String,Object>> findbyUid(@PathVariable Long id) {
		return feedService.findbyUid(id);
	}
	
	//GET ALL FEEDBACKS
	@GetMapping("admin/feedbacks")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public List<Map<String, Object>> getAllFeedbacks()
	{
		return feedService.ListAll();
	}
	
	
	//GET FEEDBACK BY USER ID
	@GetMapping("admin/feedback/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public List<Map<String, Object>> getbyIdAdmin(@PathVariable Long id) {
		return feedService.findbyUid(id);
	}
	
	//DELETE FEEDBACK BY FEEDBACK ID
	@DeleteMapping("/admin/deleteFeedback/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
	public void deleteFeedback(@PathVariable Long id) {
		feedService.deleteFeedback(id);
	}
}

