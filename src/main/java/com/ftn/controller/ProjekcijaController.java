package com.ftn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Bioskop;
import com.ftn.model.Oglas;
import com.ftn.model.Projekcija;
import com.ftn.service.ProjekcijaService;
import com.ftn.service.impl.JpaProjekcijaService;

@RestController
@RequestMapping(value = "/projekcija")
public class ProjekcijaController {
	
	@Autowired
	private JpaProjekcijaService jpaProjekcijaService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Projekcija> nadjiProjekciju(@PathVariable String id) {
		System.out.println("=================>>>>> Prije nadjiJedanBioskop:" + id);
		Projekcija projekcija = jpaProjekcijaService.nadjiJednuProjekciju(id);
		if (projekcija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Bice prikazan: " + projekcija.getNaziv());
		return new ResponseEntity<>(projekcija, HttpStatus.OK);
	}
	
	
	/*@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Projekcija> dodajProjekciju@RequestBody Projekcija projekcija){
		Projekcija novaProjekcija = projekcijaService.save(projekcija);
		//System.out.println("**************************"+oglasDTO.getNaziv());
		
		return new ResponseEntity<>(novaProjekcija, HttpStatus.OK);
	}	*/
	
	


}
