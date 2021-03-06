package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Projekcija;

@Repository
public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long> {

	Projekcija findByFilm(String film);
	
}
