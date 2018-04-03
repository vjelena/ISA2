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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ftn.model.Bioskop;
import com.ftn.service.impl.JpaBioskopService;

@RestController
public class PrikazBioskopaController {

	@Autowired
	private JpaBioskopService jpaBioskopService;
	
	@RequestMapping("/bioskopi")
//	 @JsonBackReference(value="candidate-12121")
	public List<Bioskop> prikaziBioskope() {
		return jpaBioskopService.nadjiSveBioskope();
	}
	
//	@RequestMapping("/bioskopi/{naziv}")
//	public Bioskop jedanBioskop(@PathVariable String naziv) {
//		return bioskopService.jedanBioskop(naziv);
//	}
	
	@RequestMapping(method=RequestMethod.POST, value="/bioskopi", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bioskop>> dodajBioskop(@RequestBody Bioskop bioskop) {
		System.out.println("Kreiranje bioskopa - controller");
		jpaBioskopService.kreirajBioskop(bioskop);
		return new ResponseEntity<>(jpaBioskopService.nadjiSveBioskope(), HttpStatus.OK);
//		return "uspesno..";
	}
	
}
