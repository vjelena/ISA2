package com.ftn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Korisnik;
import com.ftn.service.KorisnikService;

@RestController
@RequestMapping(value = "/adminFanzona")
public class AdminFanzoneKontroler {

	@Autowired
	private KorisnikService korisnikServis;
	
	@RequestMapping(value="/azuriraj", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean azurirajKorisnika(@RequestBody Korisnik requestKorisnik, HttpServletRequest request) {
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
			
		k.setEmail(requestKorisnik.getEmail());
		k.setLozinka(requestKorisnik.getLozinka());
		k.setIme(requestKorisnik.getIme());
		k.setPrezime(requestKorisnik.getPrezime());
		k.setAdresa(requestKorisnik.getAdresa());
		k.setBrojTelefona(requestKorisnik.getBrojTelefona());
		k.setUloga("fanzona");
		k.setAktiviranNalogPrekoMejla(true);
		k.setPrviPutSeUlogovao(false);
			
		korisnikServis.save(k);
		return true;
	}
}
