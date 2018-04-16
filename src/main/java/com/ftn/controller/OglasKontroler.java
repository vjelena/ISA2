package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Oglas;
import com.ftn.service.OglasServis;

@RestController
@RequestMapping(value = "/oglas")
public class OglasKontroler {

	@Autowired
	private OglasServis oglasServis;
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Oglas> addOglas(@RequestBody Oglas oglas){
		Oglas noviOglas = oglasServis.save(oglas);
		return new ResponseEntity<>(noviOglas, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/getOglasi", method = RequestMethod.GET)
	public ResponseEntity<List<Oglas>> getOglasi() {
		List<Oglas> oglasi = oglasServis.findAll();
		return new ResponseEntity<>(oglasi, HttpStatus.OK);
	}
}
