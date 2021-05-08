package com.example.repository;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
	
	///GET ALL FEEDBACKS
	@Modifying
	@Query(value="SELECT f.feedback,f.user_id,f.water_id,f.id,f.duration,w.city,w.area from feedback f join water w where f.water_id=w.id;", nativeQuery = true)
	List<Map<String,Object>> ListAll();
	
	
	//GET FEEDBACKS BY USER ID
	@Modifying
	@Query(value="SELECT f.feedback,f.user_id,f.water_id,f.id,f.duration from feedback f where user_id = :user_id", nativeQuery = true)
	List<Map<String,Object>> findbyUid(@PathVariable("user_id") Long user_id);
	
	

	//GET FEEDBACKS BY WATER ID
	@Query(value="SELECT f.feedback,f.user_id,f.water_id,f.id,f.duration from feedback f where water_id= :water_id", nativeQuery = true)
	List<Map<String,Object>> findbyWid(@PathVariable("water_id") Long water_id);
}
