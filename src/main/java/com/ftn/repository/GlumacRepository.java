package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Film;
import com.ftn.model.Glumac;

public interface GlumacRepository extends JpaRepository<Glumac, Long> {

}
