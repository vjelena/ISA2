package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ftn.model.Bioskop;

@Repository
public interface BioskopRepository extends JpaRepository<Bioskop, String> {

	

	
	
}
