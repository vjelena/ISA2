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

import com.ftn.model.Film;
import com.ftn.model.Glumac;
import com.ftn.service.GlumacService;
import com.ftn.service.impl.JpaGlumacService;

@RestController
@RequestMapping(value = "/glumac")
public class GlumacController {
	

	@Autowired
	private JpaGlumacService jpaGlumacService;
	
	@Autowired
	private GlumacService glumacService;
	

	@RequestMapping(value = "/getGlumci", method = RequestMethod.GET)
	public ResponseEntity<List<Glumac>> prikaziGlumce() {
		List<Glumac> glumci = jpaGlumacService.nadjiSveGlumce();
		return new ResponseEntity<>(glumci, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Glumac> nadjiGlumca(@PathVariable String id) {
		Glumac glumac = jpaGlumacService.nadjiJednogGlumca(id);
		if (glumac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(glumac, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajGlumca", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Glumac> dodajFilm(@RequestBody Glumac glumac) {
		Glumac noviGlumac = jpaGlumacService.kreirajGlumca(glumac);
		return new ResponseEntity<>(noviGlumac, HttpStatus.OK);
	}
	
}
