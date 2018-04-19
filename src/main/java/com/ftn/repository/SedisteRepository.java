package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Film;
import com.ftn.model.Sediste;

public interface SedisteRepository  extends JpaRepository<Sediste, Long>{

}
