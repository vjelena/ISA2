package com.ftn.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTO.OglasDTO;
import com.ftn.DTO.PonudaDTO;
import com.ftn.model.Korisnik;
import com.ftn.model.Oglas;
import com.ftn.model.Ponuda;
import com.ftn.service.KorisnikService;
import com.ftn.service.OglasServis;
import com.ftn.service.PonudaServis;

@RestController
@RequestMapping(value = "/oglas")
public class OglasKontroler {

	@Autowired
	private OglasServis oglasServis;
	
	@Autowired
	private PonudaServis ponudaServis;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Oglas> addOglas(@RequestBody OglasDTO oglasDTO){
		Oglas noviOglas = new Oglas();
		noviOglas.setNaziv(oglasDTO.getNaziv());
		noviOglas.setOpis(oglasDTO.getOpis());
		noviOglas.setDatum(oglasDTO.getDatum());
		noviOglas.setSlika(oglasDTO.getSlika());
		noviOglas.setCena(oglasDTO.getCena());
		noviOglas.setStatus(0);
		Korisnik korisnik = korisnikServis.findOne(oglasDTO.getKorisnikId());
		noviOglas.setKorisnik(korisnik);
		oglasServis.save(noviOglas);
		return new ResponseEntity<>(noviOglas, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/getOglasi", method = RequestMethod.GET)
	public ResponseEntity<List<Oglas>> getOglasi() {
		List<Oglas> oglasi = oglasServis.findAll();
		return new ResponseEntity<>(oglasi, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ponuda/{id}", method = RequestMethod.POST)
	public ResponseEntity<Ponuda> addPonuda(@PathVariable Long id, @RequestBody PonudaDTO ponudaDTO) {
		
		Ponuda novaPonuda = new Ponuda();
		Oglas oglas = oglasServis.findOne(id);
		Korisnik korisnik = korisnikServis.findOne(ponudaDTO.getKorisnikId());
		
		novaPonuda.setStatus(0);
		novaPonuda.setCena(ponudaDTO.getCena());
		novaPonuda.setOglas(oglas);
		novaPonuda.setPonudjac(korisnik);
		
		oglas.getListaPonuda().add(novaPonuda);

		ponudaServis.save(novaPonuda);
		return new ResponseEntity<>(novaPonuda, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getOglas/{id}", method = RequestMethod.GET)
	public ResponseEntity<Oglas> getOglas(@PathVariable Long id) {
		Oglas oglas = oglasServis.findOne(id);
		return new ResponseEntity<>(oglas, HttpStatus.OK);
	}

	@RequestMapping(value="/getPonude/{id}", method = RequestMethod.GET)
	public ResponseEntity<Set<Ponuda>> getPonude(@PathVariable Long id) {
		Oglas oglas = oglasServis.findOne(id);
		Set<Ponuda> ponude = oglas.getListaPonuda();
		return new ResponseEntity<>(ponude, HttpStatus.OK);
	}
	
	@RequestMapping(value="/izmeniPonudu/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ponuda> izmeniPonudu(@PathVariable Long id, @RequestBody PonudaDTO ponudaDTO) {
		Ponuda ponuda = ponudaServis.findOne(id);
		ponuda.setCena(ponudaDTO.getCena());
		ponudaServis.save(ponuda);
		return new ResponseEntity<>(ponuda, HttpStatus.OK);
	}
	
	@RequestMapping(value="/odobri/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Oglas> odobriOglas(@PathVariable Long id) {
		Oglas oglas = oglasServis.findOne(id);
		oglas.setStatus(1);
		oglasServis.save(oglas);
		return new ResponseEntity<>(oglas, HttpStatus.OK);
	}
}
