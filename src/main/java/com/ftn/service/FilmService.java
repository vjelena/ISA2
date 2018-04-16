package com.ftn.service;

import org.springframework.stereotype.Service;

import com.ftn.model.Film;

@Service
public interface FilmService {
	
	public Film kreirajFilm(Film film);
}
