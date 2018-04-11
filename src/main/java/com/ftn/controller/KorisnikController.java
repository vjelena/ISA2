package com.ftn.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger logger = LoggerFactory.getLogger(KorisnikController.class) ; 
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping(value="getKorisnici", method = RequestMethod.GET)
	public ResponseEntity<List<Korisnik>> getKorisnici() {
		List<Korisnik> korisnici = korisnikServis.findAll();
		return new ResponseEntity<>(korisnici, HttpStatus.OK);
	}
	
	/*
	//odabir korisnika na osnovu e-mail adrese (za logovanje i prijateljstvo)
	@RequestMapping(value="/{email}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik> getKorisnikByEmail(@PathVariable String email) {
		Korisnik korisnik = korisnikServis.findByEmail(email);
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik> getKorisnik(@PathVariable Long id) {
		Korisnik korisnik = korisnikServis.findOne(id);
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Korisnik> addKorisnik(@RequestBody Korisnik korisnik){
		Korisnik noviKorisnik = korisnikServis.save(korisnik);
		return new ResponseEntity<>(noviKorisnik, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Korisnik> delete(@PathVariable Long id) {
		Korisnik obrisan = korisnikServis.delete(id);
		return new ResponseEntity<>(obrisan, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<List<Korisnik>> search(@RequestBody Korisnik korisnik) {
		System.out.println(korisnik.getIme() + "  " + korisnik.getPrezime());
		List<Korisnik> ret = korisnikServis.search(korisnik.getIme(), korisnik.getPrezime());
		System.out.println(ret);
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}*/
	
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Korisnik> edit(@PathVariable Long id, @RequestBody Korisnik korisnik) {
		Korisnik izmenjen = korisnikServis.findOne(id);
		izmenjen.setEmail(korisnik.getEmail());
		izmenjen.setId(korisnik.getId());
		Korisnik noviKorisnik = korisnikServis.save(izmenjen);
		return new ResponseEntity<>(noviKorisnik, HttpStatus.OK);
	}*/
	
	
	/*@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<OglasDTO> addOglas(@RequestBody OglasDTO oglasDTO){
		Oglas noviOglas = oglasServis.save(toOglas.convert(oglasDTO));
		//System.out.println("**************************"+oglasDTO.getNaziv());
		
		return new ResponseEntity<>(toOglasDTO.convert(noviOglas), HttpStatus.OK);
	}*/
	
	
	//registracija korisnika
	@RequestMapping(value = "/registracija", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> registracija(@RequestBody Korisnik request) throws MailException, InterruptedException, MessagingException {		
		System.out.println("\n\t\tadresa (grad): " + request.getAdresa().getGrad());
		
		Korisnik korisnik = korisnikServis.save(request);
		//korisnik.setUloga("OBICAN");
        
        if (!korisnik.getIme().isEmpty() && !korisnik.getPrezime().isEmpty() && !korisnik.getEmail().isEmpty() && !korisnik.getLozinka().isEmpty() && !korisnik.getBrojTelefona().isEmpty() /*&& !korisnik.getAdresa().getGrad().toString().isEmpty()*/) {
        	try {
				emailService.sendMail("nijemidosadno@gmail.com", "Aktivacija korisnickog naloga", "http://localhost:8080/korisnik/aktivirajKorisnickiNalog/" + korisnik.getEmail());	        
				System.out.println("\tEmail uspesno poslat!");
        	} catch( Exception e ) {
				//logger.info("Greska prilikom slanja emaila: " + e.getMessage());
				//return new ResponseEntity<Korisnik>(korisnik, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
        }
        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
    }
	
	
	/*//slanje mejla za aktivaciju korisnickog naloga
	@RequestMapping(value = "/aktivirajKorisnickiNalog/{email:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> aktivirajKorisnickiNalog(@PathVariable String email) {
        System.out.println("aktiviranje kor naloga");
		korisnikServis.setActivated(true, email);
		System.out.println("aktiviranNalog setovan na true");
        String nalog = "Korisnicki nalog je uspesno aktiviran.";
        return new ResponseEntity<String>(nalog, HttpStatus.OK);
    }
	
	
	//prijava korisnika
	@RequestMapping(value = "/prijaviSe.html/{email:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> prijava(@PathVariable String email){
        Korisnik korisnik = korisnikServis.findByEmail(email);
        return new ResponseEntity<Korisnik>(korisnik,HttpStatus.OK);
    }
    */
}
