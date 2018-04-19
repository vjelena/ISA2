package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.PodaciORezervacijiBezPrijatelja;

@Repository
public interface PodaciORezervacijiBezPrijateljaRepository extends JpaRepository<PodaciORezervacijiBezPrijatelja, Long>  {

	
	
}
