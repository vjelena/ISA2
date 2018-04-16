package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.repository.FilmRepository;
import com.ftn.service.FilmService;

@Transactional
@Service
public class JpaFilmService implements FilmService{
	
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public Film kreirajFilm(Film film) {
		return filmRepository.save(film);
	}

	public List<Film> nadjiSveFilmove() {
		return filmRepository.findAll();
	}

	

	@Override
	public Film nadjiJedanFilm(String id) {
		
		return filmRepository.findOne(new Long(id));
	}

}
