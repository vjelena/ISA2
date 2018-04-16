package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.service.BioskopService;
import com.ftn.service.FilmService;
import com.ftn.service.impl.JpaBioskopService;
import com.ftn.service.impl.JpaFilmService;

@RestController
@RequestMapping(value = "/film")
public class FilmController {
	
	@Autowired
	private JpaFilmService jpaFilmService;
	
	@Autowired
	private FilmService filmService;
	

	@RequestMapping(value = "/getFilmovi", method = RequestMethod.GET)
	public ResponseEntity<List<Film>> prikaziBioskope() {
		List<Film> filmovi = jpaFilmService.nadjiSveFilmove();
		return new ResponseEntity<>(filmovi, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajFilm", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> dodajBioskop(@RequestBody Film film) {
		Film noviFilm = jpaFilmService.kreirajFilm(film);
		return new ResponseEntity<>(noviFilm, HttpStatus.OK);
	}

}
