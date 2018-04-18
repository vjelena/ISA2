package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Film;
import com.ftn.model.Predstava;

public interface PredstavaRepository extends JpaRepository<Predstava, Long> {

}
