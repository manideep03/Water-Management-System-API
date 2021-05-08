package com.example.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "water")
public class Water {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
    String pressure;

    @NotBlank
    String description;

    @NotBlank
    String city;

    @NotBlank
    String area;
    
    private Integer duration;
    
    
	@ManyToOne()
	private User user;
    
	public Water() {
		super();
	}
	
	public Water(Long id, @NotBlank String pressure, @NotBlank String description, @NotBlank String city,
			@NotBlank String area, Integer duration, User user) {
		super();
		this.id = id;
		this.pressure = pressure;
		this.description = description;
		this.city = city;
		this.area = area;
		this.duration = duration;
		this.user = user;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPressure() {
		return pressure;
	}



	public void setPressure(String pressure) {
		this.pressure = pressure;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
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
   
}

