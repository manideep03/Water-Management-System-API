package com.example.security.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.User;
import com.example.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
	
	@Transactional
	public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + id));

		return UserDetailsImpl.build(user);
	}
	
	//GET ALL USERS IN THE TABLE
	public List<Map<String, Object>> getUsers() {
		return userRepository.getAllUsers();
		
	}
	
	//DELETE USER BY USER ID
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	//GET USER BY ID
	 public Optional<User> findById(Long id) { 
		 return userRepository.findById(id);
	 }

}