package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTO.FilmDTO;
import com.ftn.DTOconverter.FilmDTOtoFilm;
import com.ftn.DTOconverter.ProjekcijaDTOtoProjekcija;
import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.model.Projekcija;
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
	
	@Autowired
	private FilmDTOtoFilm toFilm;
	

	@RequestMapping(value = "/getFilmovi", method = RequestMethod.GET)
	public ResponseEntity<List<Film>> prikaziFilmove() {
		List<Film> filmovi = jpaFilmService.nadjiSveFilmove();
		return new ResponseEntity<>(filmovi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Film> nadjiProjekciju(@PathVariable String id) {
		Film film = jpaFilmService.nadjiJedanFilm(id);
		if (film == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(film, HttpStatus.OK);
	}
	
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/dodajFilm", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> dodajFilm(@RequestBody Film film) {
		Film noviFilm = jpaFilmService.kreirajFilm(film);
		return new ResponseEntity<>(noviFilm, HttpStatus.OK);
	}*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajFilm", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> dodajFilm(@RequestBody FilmDTO filmDTO) {
		System.out.println("FilmDTO: " + filmDTO);
		Film film = toFilm.convert(filmDTO);
		System.out.println("Konvertovani film: " + film );
		Film noviFilm = filmService.kreirajFilm(film);
		
		return new ResponseEntity<>(noviFilm, HttpStatus.OK);
	}

}
