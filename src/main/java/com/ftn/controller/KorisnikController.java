package com.ftn.controller;

import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ftn.model.Korisnik;
import com.ftn.service.EmailService;
import com.ftn.service.KorisnikService;

//test git-a
@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/korisnici")
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikServis;
	
	
	@RequestMapping(value="getKorisnici", method = RequestMethod.GET)
	public ResponseEntity<List<Korisnik>> getKorisnici() {
		List<Korisnik> korisnici = korisnikServis.findAll();
		return new ResponseEntity<>(korisnici, HttpStatus.OK);
	}
	
	
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
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Korisnik> edit(@PathVariable Long id, @RequestBody Korisnik korisnik) {
		Korisnik izmenjen = korisnikServis.findOne(id);
		izmenjen.setEmail(korisnik.getEmail());
		izmenjen.setId(korisnik.getId());
		Korisnik noviKorisnik = korisnikServis.save(izmenjen);
		return new ResponseEntity<>(noviKorisnik, HttpStatus.OK);
	}
	
	/* NE RADIIIIIII :(
	//registracija korisnika
	@RequestMapping(value = "/registrujSe.html", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> registracija(@RequestBody Korisnik request) throws MailException, InterruptedException, MessagingException {
        Korisnik korisnik = request;
        korisnikServis.save(korisnik);
        EmailServis.sendMail("nijemidosadno@gmail.com", "Aktivacija naloga", "http://localhost:8080/aktivirajKorisnickiNalog/\"+korisnik.getEmail()");
        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
    }
	
	
	//slanje mejla za aktivaciju korisnickog naloga
	@RequestMapping(value = "/aktivirajKorisnickiNalog/{email:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> aktivirajKorisnickiNalog(@PathVariable String email) {
        Integer aktiviran = korisnikServis.setActivated(true, email);
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
