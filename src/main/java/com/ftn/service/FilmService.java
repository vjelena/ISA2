package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
import com.ftn.model.Film;

@Service
public interface FilmService {
	
	public List<Film> nadjiSveFilmove();
	
	
	public Film kreirajFilm(Film film);


	public Film nadjiJedanFilm(String id);
}
