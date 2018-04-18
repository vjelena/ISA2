package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Film;
import com.ftn.model.Karta;
import com.ftn.service.KartaService;
import com.ftn.service.impl.JpaKartaService;

@RestController
@RequestMapping(value = "/karta")
public class KartaController {
	
	@Autowired
	private JpaKartaService jpaKartaService;
	
	@Autowired
	private KartaService kartaService;
	

	@RequestMapping(value = "/getKarte", method = RequestMethod.GET)
	public ResponseEntity<List<Karta>> prikaziKarte() {
		List<Karta> karte = jpaKartaService.nadjiSveKarte();
		return new ResponseEntity<>(karte, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Karta> nadjiKartu(@PathVariable String id) {
		Karta karta = jpaKartaService.nadjiJednuKartu(id);
		if (karta == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(karta, HttpStatus.OK);
	}
}