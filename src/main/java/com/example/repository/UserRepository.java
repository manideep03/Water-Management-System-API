package com.example.repository;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	
	Optional<User> findById(Long id);


	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value = "select u.id,u.username,u.phone,u.email from users u",nativeQuery = true)
	public List<Map<String,Object>> getAllUsers();
}
