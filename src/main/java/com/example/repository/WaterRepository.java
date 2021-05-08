package com.example.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.models.Water;


@Repository
public interface WaterRepository extends JpaRepository<Water, Long> {
	
	Optional<Water> findById(Long id);
	
	
	//GET WATER BY WATER ID
	@Query(value = "SELECT w.area,w.city,w.description,w.duration,w.pressure,w.id,w.user_id from water w where w.id =:id",nativeQuery = true)
	List<Map<String, Object>> findByWid(@PathVariable("id") Long id);
	
	
	//GET WATER BY CITY
	@Query(value = "SELECT w.area,w.city,w.description,w.duration,w.pressure,w.id,w.user_id from water w where w.city =:city",nativeQuery = true)
	List<Map<String, Object>> findbyCity(@PathVariable("city") String city);
	
	
	//GET WATER BY WATER USER ID
	@Modifying
	@Query(value="SELECT w.area,w.city,w.description,w.duration,w.pressure,w.id,w.user_id from water w where w.user_id = :user_id", nativeQuery = true)
	List<Map<String, Object>> findByUid(@PathVariable("user_id") Long user_id);
	
	
	// GET WATER
	@Modifying
	@Query(
			value="SELECT w.area,w.city,w.description,w.duration,w.pressure,u.phone,u.id FROM water w JOIN users u ON w.user_id=u.id where u.id=?1",nativeQuery = true)
	public List<Map<String,Object>>getwaterinfo(@PathVariable Long id);
	
	@Query(value = "SELECT w.area,w.city,w.description,w.duration,w.pressure,w.id,w.user_id,u.phone FROM water w JOIN users u where w.user_id = u.id",nativeQuery = true)
	public List<Map<String,Object>>getWaters();
	 

}

