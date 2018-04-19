package com.ftn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTOconverter.FilmDTOtoFilm;
import com.ftn.model.Film;
import com.ftn.model.Sediste;
import com.ftn.service.FilmService;
import com.ftn.service.impl.JpaFilmService;
import com.ftn.service.impl.JpaSedisteService;

@RestController
@RequestMapping(value = "/sediste")
public class SedisteController {
	
	@Autowired
	private JpaSedisteService jpaSedisteService;
	
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sediste> nadjiSediste(@PathVariable String id) {
		Sediste sediste = jpaSedisteService.nadjiJednoSediste(id);
		if (sediste == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(sediste, HttpStatus.OK);
	}
}
