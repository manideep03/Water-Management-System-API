package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Awareness;


@Repository
public interface AwarenessRepository extends JpaRepository<Awareness, Long>{

	Optional<Awareness> findById(Long id);
}
