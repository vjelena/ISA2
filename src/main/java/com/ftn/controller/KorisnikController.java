package com.ftn.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Korisnik;
import com.ftn.service.EmailService;
import com.ftn.service.KorisnikService;

@RestController
@RequestMapping(value = "/korisnik")
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private EmailService emailService;
	
	
	//preuzimanje svih korisnika
	@RequestMapping(value="getKorisnici", method = RequestMethod.GET)
	public ResponseEntity<List<Korisnik>> getKorisnici() {
		List<Korisnik> korisnici = korisnikServis.findAll();
		
		if(korisnici.equals(null)) {
			return new ResponseEntity<>(korisnici, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(korisnici, HttpStatus.OK);
	}
	
	//registracija korisnika
	@RequestMapping(value = "/registracija", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> registracija(@RequestBody Korisnik request) throws MailException, InterruptedException, MessagingException {		
		Korisnik k = new Korisnik(request.getEmail(), request.getLozinka(), request.getIme(), request.getPrezime(), request.getAdresa(), request.getBrojTelefona(), request.getUloga(), request.isAktiviranNalogPrekoMejla(), request.isPrviPutSeUlogovao());
							
		for(Korisnik kor : korisnikServis.findAll()) {
			if(!kor.getEmail().equals(k.getEmail())) {
				if(!k.getEmail().isEmpty() && !k.getLozinka().isEmpty() && !k.getIme().isEmpty() && !k.getPrezime().isEmpty() && !k.getAdresa().getUlica().toString().isEmpty() && !k.getAdresa().getBroj().toString().isEmpty() && !k.getAdresa().getGrad().toString().isEmpty() && !k.getBrojTelefona().isEmpty()) {		
					k.setUloga("obican");
					k.setAktiviranNalogPrekoMejla(false);
					k.setPrviPutSeUlogovao(false);
					emailService.sendMail(k);
					korisnikServis.save(k);
					return new ResponseEntity<Korisnik>(k, HttpStatus.OK);
				}
			}
		}
		
		return new ResponseEntity<Korisnik>(k, HttpStatus.BAD_REQUEST);
	}
	
	//aktivacija korisnickog naloga posetom linka iz mejla
	@RequestMapping(value = "/aktivirajKorisnickiNalog/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> aktivirajKorisnickiNalog(@PathVariable String email) {
		Korisnik k = korisnikServis.findByEmail(email);
		k.setAktiviranNalogPrekoMejla(true);
		korisnikServis.save(k);
	    return new ResponseEntity<Korisnik>(k, HttpStatus.OK);
	 }
		
	//prijava korisnika
	@RequestMapping(value = "/prijava", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> prijava(@RequestBody Korisnik requestKorisnik, HttpServletRequest request){
		Korisnik k = korisnikServis.findByEmail(requestKorisnik.getEmail());
		
		if(k != null) {
			if(k.getLozinka().equals(requestKorisnik.getLozinka()) && k.isAktiviranNalogPrekoMejla() == true) {
				if(k.isPrviPutSeUlogovao() == false) {
					k.setPrviPutSeUlogovao(true);
				}
				request.getSession().setAttribute("aktivanKorisnik", k);
				return new ResponseEntity<Korisnik>(k, HttpStatus.OK);
			}
		} else {
			System.out.println("\n\t\tNe postoji korisnik sa unetim emailom i lozinkom u bazi!\n");
		}
			
		return new ResponseEntity<Korisnik>(k, HttpStatus.NOT_FOUND);
	}
	
	//odjava korisnika
	@RequestMapping(value = "/odjava", method = RequestMethod.GET)
	public String odjava(HttpServletRequest request) {
		request.getSession().invalidate();
		return "odjavljen";
	}
	
	//azuriranje korisnika
	@RequestMapping(value="/azurirajKorisnika", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean azurirajKorisnika(@RequestBody Korisnik requestKorisnik, HttpServletRequest request) {
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
			
		k.setEmail(requestKorisnik.getEmail());
		k.setLozinka(requestKorisnik.getLozinka());
		k.setIme(requestKorisnik.getIme());
		k.setPrezime(requestKorisnik.getPrezime());
		k.setAdresa(requestKorisnik.getAdresa());
		k.setBrojTelefona(requestKorisnik.getBrojTelefona());
		k.setUloga("obican");
		k.setAktiviranNalogPrekoMejla(true);
		k.setPrviPutSeUlogovao(false);
			
		korisnikServis.save(k);
		return true;
	}
	
	
	
	
	//NIJE GOTOVO!!!
	//preuzimanje aktivnog korisnika
	@RequestMapping(value = "/getTrenutnoAktivan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Korisnik getTrenutnoAktivan(HttpServletRequest request){
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");		
		System.out.println("\n\t\ttrenutno aktivan korisnik: " + k.getEmail() + "\n");
		return k;
	}
	
	
	
	
	
	/*
	//odabir korisnika na osnovu e-mail adrese (za prijateljstvo)
	@RequestMapping(value="/{email}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik> getKorisnikByEmail(@PathVariable String email) {
		Korisnik korisnik = korisnikServis.findByEmail(email);
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}*/
	
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik> getKorisnik(@PathVariable Long id) {
		Korisnik korisnik = korisnikServis.findOne(id);
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}*/
	
	
	/*@RequestMapping(value="/search", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<List<Korisnik>> search(@RequestBody Korisnik korisnik) {
		System.out.println(korisnik.getIme() + "  " + korisnik.getPrezime());
		List<Korisnik> ret = korisnikServis.search(korisnik.getIme(), korisnik.getPrezime());
		System.out.println(ret);
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}*/
}
