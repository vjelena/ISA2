package com.ftn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Bioskop;
import com.ftn.model.Sala;
import com.ftn.repository.BioskopRepository;
import com.ftn.repository.SalaRepository;
import com.ftn.service.impl.JpaBioskopService;
import com.ftn.service.impl.JpaSalaService;

@RestController
@RequestMapping(value = "/sala")
public class SalaController {
	

	@Autowired
	private JpaSalaService jpaSalaService;
	
	@Autowired
	private SalaRepository salaRepository;

	@RequestMapping(value = "/konfiguracije/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> uzmiKonfiguraciju(@PathVariable String id) {
		System.out.println("id sale: " + id);
		Sala sala = jpaSalaService.nadjiJednuSalu(id);
			
		String konfiguracija = sala.getKonfiguracija();

		return new ResponseEntity<>(konfiguracija, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sala> nadjiBioskop(@PathVariable String id) {
		System.out.println("=================>>>>> id sale:" + id);
		Sala sala = jpaSalaService.nadjiJednuSalu(id);
		if (sala == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(sala, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/{konfiguracija}", method = RequestMethod.GET)
	public ResponseEntity<Sala> izmjeniKonfiguraciju(@PathVariable String id, @PathVariable String konfiguracija) {
		System.out.println("=================>>>>>:" + id + "_____" + konfiguracija);
		
		Sala sala = jpaSalaService.nadjiJednuSalu(id);
			
		sala.setKonfiguracija(konfiguracija);

		sala = jpaSalaService.azurirajKonfiguraciju(sala);
		if (sala== null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(sala, HttpStatus.OK);
	}

}