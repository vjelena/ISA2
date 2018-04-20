package com.ftn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTO.FilmDTO;
import com.ftn.DTO.KartaDTO;
import com.ftn.DTOconverter.KartaDTOtoKarta;
import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.model.Karta;
import com.ftn.model.Korisnik;
import com.ftn.repository.KorisnikRepository;
import com.ftn.service.KartaService;
import com.ftn.service.impl.JpaKartaService;
import com.ftn.service.impl.JpaSedisteService;

@RestController
@RequestMapping(value = "/karta")
public class KartaController {
	
	@Autowired
	private JpaKartaService jpaKartaService;
	
	@Autowired
	private KartaService kartaService;
	
	@Autowired
	private JpaSedisteService jpaSedisteService ;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private KartaDTOtoKarta  toKarta;
	

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
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajBrzuKartu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Karta> dodajBrzuKartu(@RequestBody KartaDTO kartaDTO) {
		
		Karta karta = toKarta.convert(kartaDTO);
		
		jpaSedisteService.kreirajSediste(karta.getSediste());
		
		Karta novaKarta = kartaService.kreirajKartu(karta);
		
		return new ResponseEntity<>(novaKarta, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/izbrisiKartu/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void izbrisiKartu(@PathVariable Long id, HttpServletRequest request){
		Karta karta = jpaKartaService.nadjiJednuKartu(Long.toString(id));
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik kupac = korisnikRepository.findById(k.getId());
		Bioskop bioskop = karta.getProjekcija().getRepertoar().getBioskop();
		kupac.getPoseceniBioskopi().add(bioskop);
		karta.setKupljena(true);
		
		kartaService.remove(id);
	}
	
}