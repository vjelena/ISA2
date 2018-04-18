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

import com.ftn.DTO.ProjekcijaDTO;
import com.ftn.DTO.SalaDTO;
import com.ftn.DTOconverter.ProjekcijaDTOtoProjekcija;
import com.ftn.DTOconverter.SalaDTOtoSala;
import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.model.Projekcija;
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
	
	@Autowired
	private JpaBioskopService jpaBioskopService;
	
	@Autowired
	private SalaDTOtoSala toSala;
	
	
	@RequestMapping(value = "/getSale", method = RequestMethod.GET)
	public ResponseEntity<List<Sala>> prikaziSale() {
		List<Sala> sale = jpaSalaService.nadjiSveSale();
		return new ResponseEntity<>(sale, HttpStatus.OK);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/dodajSalu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sala> dodajBioskop(@RequestBody Sala sala) {
		Sala novaSala = jpaSalaService.kreirajSalu(sala);
		return new ResponseEntity<>(novaSala, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/dodajSalu", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Sala> dodajSalu( @RequestBody SalaDTO salaDTO) {
		String idBioskopa = salaDTO.getBioskopId();
		Bioskop bioskop = jpaBioskopService.nadjiJedanBioskop(idBioskopa);
		
		Sala sala = jpaSalaService.kreirajSalu(toSala.convert(salaDTO));
		bioskop.getListaSala().add(sala);
		jpaBioskopService.save(bioskop);
		return new ResponseEntity<>(sala, HttpStatus.OK);
	}


	@RequestMapping(value = "/konfiguracije/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> uzmiKonfiguraciju(@PathVariable String id) {
		System.out.println("id sale: " + id);
		Sala sala = jpaSalaService.nadjiJednuSalu(id);
			
		String konfiguracija = sala.getKonfiguracija();

		return new ResponseEntity<>(konfiguracija, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sala> nadjiSalu(@PathVariable String id) {
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
