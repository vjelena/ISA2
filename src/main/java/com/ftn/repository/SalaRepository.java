package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Bioskop;
import com.ftn.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
