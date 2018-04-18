package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Film;
import com.ftn.model.Karta;

public interface KartaRepository extends JpaRepository<Karta, Long> {

}
