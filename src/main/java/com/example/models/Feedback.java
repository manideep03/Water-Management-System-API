package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String feedback;
	
	private Integer duration;
	
	
	@ManyToOne()
	private User user;
	
	@ManyToOne()
	private Water water;
	

	public Feedback() {
		super();
	}
	
	


	public Feedback(Long id, String feedback, Integer duration, User user, Water water) {
		super();
		this.id = id;
		this.feedback = feedback;
		this.duration = duration;
		this.user = user;
		this.water = water;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Water getWater() {
		return water;
	}


	public void setWater(Water water) {
		this.water = water;
	}


	
}
