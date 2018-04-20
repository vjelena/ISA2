package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.ObicnaRezervacija;

@Repository
public interface ObicnaRezervacijaRepository extends JpaRepository<ObicnaRezervacija, Long> {

	ObicnaRezervacija findById(Long id);
	
}
