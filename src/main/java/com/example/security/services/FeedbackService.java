package com.example.security.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Feedback;
import com.example.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	//SAVE NEW FEEDBACK
	public void savefeedback(Feedback feedback){
		feedbackRepository.save(feedback);
		
	}
	
	//LIST ALL FEEDBACKS BY USER id;
	public List<Map<String,Object>> findbyUid(Long id) {
		return feedbackRepository.findbyUid(id);
	}
	
	
	//LIST FEEDBACK BY WATER id
	public List<Map<String,Object>> findbyWid(Long id) {
		return feedbackRepository.findbyWid(id);
	}
	
	
	//LIST ALL FEEDBACKS
	public List<Map<String,Object>> ListAll(){
		return feedbackRepository.ListAll();
	}
	
	
	//UPDATE FEEDBACK BY FEEDBACK ID
	public void updateWater(Long id,Feedback feedback) {
		feedbackRepository.save(feedback);
	}
	
	//DELETE FEEDBACK BY FEEDBACK ID
	public void deleteFeedback(Long id) {
		feedbackRepository.deleteById(id);
	}

}
