package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Sala;
import com.ftn.model.Termin;

public interface TerminRepository extends JpaRepository<Termin, Long> {

}
