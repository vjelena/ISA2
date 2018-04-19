package com.ftn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.PodaciORezervaciji;

@Repository
public interface PodaciORezervacijiRepository extends JpaRepository<PodaciORezervaciji, Long> {

	
	
}
