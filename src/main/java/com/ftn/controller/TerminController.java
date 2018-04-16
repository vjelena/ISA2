package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Sala;
import com.ftn.model.Termin;
import com.ftn.repository.SalaRepository;
import com.ftn.repository.TerminRepository;
import com.ftn.service.impl.JpaSalaService;
import com.ftn.service.impl.JpaTerminService;

@RestController
@RequestMapping(value = "/termin")
public class TerminController {
	
	@Autowired
	private JpaTerminService jpaTerminService;
	
	@Autowired
	private TerminRepository terminRepository;
	
	
	@RequestMapping(value = "/getTermini", method = RequestMethod.GET)
	public ResponseEntity<List<Termin>> prikaziTermine() {
		List<Termin> termini = jpaTerminService.nadjiSveTermine();
		return new ResponseEntity<>(termini, HttpStatus.OK);
	}

}
