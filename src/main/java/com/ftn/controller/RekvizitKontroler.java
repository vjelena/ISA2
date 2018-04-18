package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTO.RekvizitDTO;
import com.ftn.model.Film;
import com.ftn.model.Oglas;
import com.ftn.model.Rekvizit;
import com.ftn.service.FilmService;
import com.ftn.service.RekvizitServis;

@RestController
@RequestMapping(value = "/rekvizit")
public class RekvizitKontroler {

	@Autowired
	private RekvizitServis rekvizitServis;
	
	@Autowired
	private FilmService filmService;
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Rekvizit> addRekvizit(@RequestBody RekvizitDTO rekvizitDTO){
		System.out.println("****"+rekvizitDTO.toString());
		Rekvizit noviRekvizit = new Rekvizit();
		noviRekvizit.setNaziv(rekvizitDTO.getNaziv());
		noviRekvizit.setOpis(rekvizitDTO.getOpis());
		noviRekvizit.setCena(rekvizitDTO.getCena());
		noviRekvizit.setSlika(rekvizitDTO.getSlika());
		Film film = filmService.findOne(rekvizitDTO.getFilmId());
		noviRekvizit.setFilm(film);
		rekvizitServis.save(noviRekvizit);
		return new ResponseEntity<>(noviRekvizit, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/getRekviziti", method = RequestMethod.GET)
	public ResponseEntity<List<Rekvizit>> getRekviziti() {
		List<Rekvizit> rekviziti = rekvizitServis.findAll();
		return new ResponseEntity<>(rekviziti, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Rekvizit> delete(@PathVariable Long id) {
		Rekvizit deleted = rekvizitServis.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getRekvizit/{id}", method = RequestMethod.GET)
	public ResponseEntity<Rekvizit> getRekvizit(@PathVariable Long id) {
		Rekvizit rekvizit = rekvizitServis.findOne(id);
		return new ResponseEntity<>(rekvizit, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/azurirajRekvizit/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Rekvizit> azurirajRekvizit(@PathVariable Long id, @RequestBody RekvizitDTO rekvizitDTO) {		
		Rekvizit rekvizit = rekvizitServis.findOne(id);
		rekvizit.setNaziv(rekvizitDTO.getNaziv());
		rekvizit.setOpis(rekvizitDTO.getOpis());
		rekvizit.setCena(rekvizitDTO.getCena());
		rekvizit.setSlika(rekvizitDTO.getSlika());
		Film film = filmService.findOne(rekvizitDTO.getFilmId());
		rekvizit.setFilm(film);
		rekvizitServis.save(rekvizit);
		return new ResponseEntity<>(rekvizit, HttpStatus.OK);
	}
}
