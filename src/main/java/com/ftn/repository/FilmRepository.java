package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Bioskop;
import com.ftn.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long>{

}
