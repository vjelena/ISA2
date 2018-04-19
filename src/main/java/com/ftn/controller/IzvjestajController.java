package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.IzvestajOPoslovanju;
import com.ftn.service.IzvjestajService;
import com.ftn.service.impl.JpaIzvjestajService;

@RestController
@RequestMapping(value = "/izvjestaj")
public class IzvjestajController {
	
	@Autowired
	private JpaIzvjestajService jpaIzvjestajService;
	
	@Autowired
	private IzvjestajService izvjestajService;

	@RequestMapping(value = "/getIzvjestaji", method = RequestMethod.GET)
	public ResponseEntity<List<IzvestajOPoslovanju>> prikaziIzvjestaje() {
		List<IzvestajOPoslovanju> izvjestaji = jpaIzvjestajService.nadjiSveIzvjestaje();
		return new ResponseEntity<>(izvjestaji, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<IzvestajOPoslovanju> nadjiIzvjestaj(@PathVariable String id) {
		List<IzvestajOPoslovanju> izvjestaji = jpaIzvjestajService.nadjiSveIzvjestaje();
		Long idBioskopa = new Long(id);
	
		for(int i=0;i<izvjestaji.size();i++) {
			System.out.println("=======Id trenutnog bioskopa: " + izvjestaji.get(i).getBioskop().getId());
			if(izvjestaji.get(i).getBioskop().getId().equals(idBioskopa)) {
				System.out.println("==== NASLI BIOSKOP ZA IZVJESTA ====");
				IzvestajOPoslovanju iop = izvjestaji.get(i);
				System.out.println("Bice prikazani: " + iop.getPrihod() + " " + iop.getProsecnaOcenaAmbijenta() + " " + iop.getProsecnaOcenaProjekcije());
				return new ResponseEntity<>(izvjestaji.get(i), HttpStatus.OK);
			}
		}
		System.out.println("-------Vracam prazan izvjestaj!!!!!");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	