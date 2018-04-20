package com.ftn.controller;

import java.util.ArrayList;
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

import com.ftn.model.Bioskop;
import com.ftn.model.Korisnik;
import com.ftn.model.Pozoriste;
import com.ftn.model.Skala;
import com.ftn.repository.KorisnikRepository;
import com.ftn.repository.SkalaRepository;
import com.ftn.service.EmailService;
import com.ftn.service.KorisnikService;

@RestController
@RequestMapping(value = "/korisnik")
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SkalaRepository skalaRepository;
	
	public int kolikoSePutaUlogovao = 0;
	
	//preuzimanje korisnika sa zadatim id-em
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik> getKorisnik(@PathVariable Long id) {
		Korisnik korisnik = korisnikServis.findOne(id);
		
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}
	
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
		Korisnik k = new Korisnik(request.getEmail(), request.getLozinka(), request.getIme(), request.getPrezime(), request.getAdresa(), request.getBrojTelefona(), request.getUloga(), request.isAktiviranNalogPrekoMejla(), request.isPrviPutSeUlogovao(), request.getVrstaClana());
							
		for(Korisnik kor : korisnikServis.findAll()) {
			if(!kor.getEmail().equals(k.getEmail())) {
				if(!k.getEmail().isEmpty() && !k.getLozinka().isEmpty() && !k.getIme().isEmpty() && !k.getPrezime().isEmpty() && !k.getAdresa().getUlica().toString().isEmpty() && !k.getAdresa().getBroj().toString().isEmpty() && !k.getAdresa().getGrad().toString().isEmpty() && !k.getBrojTelefona().isEmpty()) {		
					k.setUloga("obican");
					k.setAktiviranNalogPrekoMejla(false);
					k.setPrviPutSeUlogovao(false);
					k.setVrstaClana("nema pravo na popust"); //inicijalno: znaci da nema dovoljan broj bodova da bi mogao da postane bronzani clan
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
				
				//za odredjivanje vrste clana na osnovu broja poseta (ovo odredjuje administrator sistema)
				kolikoSePutaUlogovao = k.getBrojPoseta();
				kolikoSePutaUlogovao++;
				k.setBrojPoseta(kolikoSePutaUlogovao);
				
				request.getSession().setAttribute("aktivanKorisnik", k);
				
				korisnikServis.save(k);
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
	
	//preuzimanje aktivnog korisnika
	@RequestMapping(value = "/getTrenutnoAktivan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Korisnik getTrenutnoAktivan(HttpServletRequest request){
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");		
		return k;
	}
	
	
	//PRIJATELJSTVO:	
	//preuzimanje liste prijatelja
	@RequestMapping(value = "/getListaPrijatelja", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Korisnik>> getListaPrijatelja(HttpServletRequest request){
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
		Korisnik cijePrijateljeUzimam = korisnikRepository.findById(k.getId());
		
		//u listu stavljam sve moje prijatelje
		List<Korisnik> listaPrijatelja = new ArrayList<Korisnik>();
		listaPrijatelja.addAll(cijePrijateljeUzimam.getMojiPrijatelji());		
		
		return new ResponseEntity<>(listaPrijatelja, HttpStatus.OK);
	}
	
	//slanje zahteva za prijateljstvo
	@RequestMapping(value = "/posaljiZahtevZaPrijateljstvo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean posaljiZahtevZaPrijateljstvo(@PathVariable Long id, HttpServletRequest request){			
		Korisnik koJePoslaoZahtev = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");	
		Korisnik koJePrimioZahtev = (Korisnik) korisnikRepository.findById(id);			
		
		//moj zahtev dodajem u listu zahteva za prijateljstvo onoga kome saljem zahtev (ukoliko nije vec dodat u listu)
		for(int i = 0; i < koJePrimioZahtev.getZahteviZaPrijateljstvo().size(); i++) {
			if(koJePrimioZahtev.getZahteviZaPrijateljstvo().get(i).getId().equals(koJePoslaoZahtev.getId())) {
				return false;
			}
		}		
		koJePrimioZahtev.getZahteviZaPrijateljstvo().add(koJePoslaoZahtev);
		
		korisnikServis.save(koJePrimioZahtev);
		return true;
	}
	
	//brisanje prijatelja
	@RequestMapping(value = "/izbrisiPrijatelja/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean izbrisiPrijatelja(@PathVariable Long id, HttpServletRequest request){		
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJePoslaoZahtevZaBrisanje = korisnikRepository.findById(k.getId());
		Korisnik komeJePoslatZahtevZaBrsianje = korisnikRepository.findById(id);
		
		//iz mojih prijatelja brisem onog sa kim zelim da prekinem prijateljstvo (lista: mojiPrijatelji)
		for(int i = 0; i < koJePoslaoZahtevZaBrisanje.getMojiPrijatelji().size(); i++) {
			if(koJePoslaoZahtevZaBrisanje.getMojiPrijatelji().get(i).getId().equals(id)) {
				koJePoslaoZahtevZaBrisanje.getMojiPrijatelji().remove(i);				
			}
		}
		
		//iz mojih prijatelja brisem onog sa kim zelim da prekinem prijateljstvo (lista: komeSamJaPrijatelj)
		for(int i = 0; i < koJePoslaoZahtevZaBrisanje.getKomeSamJaPrijatelj().size(); i++) {
			if(koJePoslaoZahtevZaBrisanje.getKomeSamJaPrijatelj().get(i).getId().equals(id)) {
				koJePoslaoZahtevZaBrisanje.getKomeSamJaPrijatelj().remove(i);				
			}
		}
		
		
		//mene brisem iz liste prijatelja onoga sa kim zelim da prekinem prijateljstvo (lista: mojiPrijatelji)
		for(int i = 0; i < komeJePoslatZahtevZaBrsianje.getMojiPrijatelji().size(); i++) {
			if(komeJePoslatZahtevZaBrsianje.getMojiPrijatelji().get(i).getId().equals(koJePoslaoZahtevZaBrisanje.getId())) {
				komeJePoslatZahtevZaBrsianje.getMojiPrijatelji().remove(i);				
			}
		}
		
		//mene brisem iz liste prijatelja onoga sa kim zelim da prekinem prijateljstvo (lista: komeSamJaPrijatelj)
		for(int i = 0; i < komeJePoslatZahtevZaBrsianje.getKomeSamJaPrijatelj().size(); i++) {
			if(komeJePoslatZahtevZaBrsianje.getKomeSamJaPrijatelj().get(i).getId().equals(koJePoslaoZahtevZaBrisanje.getId())) {
				komeJePoslatZahtevZaBrsianje.getKomeSamJaPrijatelj().remove(i);				
			}
		}
		
		
		korisnikRepository.save(koJePoslaoZahtevZaBrisanje);
		korisnikRepository.save(komeJePoslatZahtevZaBrsianje);
		return true;
	}
	
	//preuzimanje zahteva za prijateljstvo
	@RequestMapping(value = "/getZahteviZaPrijateljstvo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Korisnik>> getZahteviZaPrijateljstvo(HttpServletRequest request){
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
		Korisnik cijiSuZahteviPreuzeti = korisnikRepository.findById(k.getId());	
		return new ResponseEntity<>(cijiSuZahteviPreuzeti.getZahteviZaPrijateljstvo(), HttpStatus.OK);
	}
	
	//prihvatanje zahteva za prijateljstvo
	@RequestMapping(value = "/prihvatiZahtevZaPrijateljstvo/{id}",	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Korisnik prihvatiZahtevZaPrijateljstvo(@PathVariable Long id, HttpServletRequest request){	
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");		
		Korisnik koJePoslaoZahtev = korisnikRepository.findById(k.getId());
		Korisnik koJePrimioZahtev = korisnikRepository.findById(id);
		
		//bez obzira na to da li je korisnik vec prijatelj, ponistava se zahtev za prijateljstvo
		koJePoslaoZahtev.getZahteviZaPrijateljstvo().remove(koJePrimioZahtev);
		koJePrimioZahtev.getZahteviZaPrijateljstvo().remove(koJePoslaoZahtev);	
		
		//ako je korisnik kome je upucen zahtev za prijateljstvo vec u prijatelj sa onim ko mu je poslao zahtev,
		//ne dodaje se ponovo u listu
		for(int i = 0; i < koJePoslaoZahtev.getMojiPrijatelji().size(); i++) {
			if(koJePrimioZahtev.getMojiPrijatelji().get(i).getId().equals(koJePoslaoZahtev.getId())) {
				return null;
			}
		}		
		koJePoslaoZahtev.getMojiPrijatelji().add(koJePrimioZahtev);
		koJePrimioZahtev.getMojiPrijatelji().add(koJePoslaoZahtev);
		
		korisnikServis.save(koJePoslaoZahtev);
		korisnikServis.save(koJePrimioZahtev);
		return koJePoslaoZahtev;		
	}
	
	//odbijanje zahteva za prijateljstvo
	@RequestMapping(value = "/odbijZahtevZaPrijateljstvo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Korisnik odbijZahtevZaPrijateljstvo(@PathVariable Long id,HttpServletRequest request){
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJePrimioZahtev = korisnikRepository.findById(k.getId());
		Korisnik koJePoslaoZahtev = korisnikRepository.findById(id);
		
		koJePrimioZahtev.getZahteviZaPrijateljstvo().remove(koJePoslaoZahtev);
		
		korisnikServis.save(koJePrimioZahtev);		
		return koJePoslaoZahtev;		
	}
	
	//pretraga prijatelja
	@RequestMapping(value = "/pretraziPrijatelje/{ime}/{prezime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Korisnik>> pretraziPrijatelje(@PathVariable String ime, @PathVariable String prezime, HttpServletRequest request){
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
		Korisnik cijePrijateljeUzimam = korisnikRepository.findById(k.getId());		
		
		if(ime.equals("nemaUnosa") && prezime.equals("nemaUnosa"))
			return new ResponseEntity<>(cijePrijateljeUzimam.getMojiPrijatelji(), HttpStatus.OK);
		else if(!ime.equals("nemaUnosa") && prezime.equals("nemaUnosa"))
			return new ResponseEntity<>(korisnikRepository.findByImeIgnoreCaseContaining(ime), HttpStatus.OK);
		else if(ime.equals("nemaUnosa") && !prezime.equals("nemaUnosa"))
			return new ResponseEntity<>(korisnikRepository.findByPrezimeIgnoreCaseContaining(prezime), HttpStatus.OK);		
		else
			return new ResponseEntity<>(korisnikRepository.findByImeIgnoreCaseContainingAndPrezimeIgnoreCaseContaining(ime, prezime), HttpStatus.OK);
	}
	
	
	//ISTORIJA POSETA:
	//preuzimanje posecenih bioskopa prijavljenog korisnika
	@RequestMapping(value = "/getPoseceniBioskopi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bioskop>> getPoseceniBioskopi(HttpServletRequest request){						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik posetilac = korisnikRepository.findById(k.getId());
		
		System.out.println("\n\t\t\tPoseceni bioskopi ulogovanog korisnika:\n");
		for(int i = 0; i < posetilac.getPoseceniBioskopi().size(); i++) {
			System.out.println("\t\t\tnaziv bioskopa: " + posetilac.getPoseceniBioskopi().get(i).getNaziv());
		}
		
		return new ResponseEntity<>(posetilac.getPoseceniBioskopi(), HttpStatus.OK);
	}
	
	//preuzimanje posecenih pozorista prijavljenog korisnika
	@RequestMapping(value = "/getPosecenaPozorista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pozoriste>> getPosecenaPozorista(HttpServletRequest request){						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik posetilac = korisnikRepository.findById(k.getId());		
		
		System.out.println("\n\t\t\tPosecena pozorista ulogovanog korisnika:\n");
		for(int i = 0; i < posetilac.getPosecenaPozorista().size(); i++) {
			System.out.println("\t\t\tnaziv pozorista: " + posetilac.getPosecenaPozorista().get(i).getNaziv());
		}
		
		return new ResponseEntity<>(posetilac.getPosecenaPozorista(), HttpStatus.OK);
	}
	
	//POSTAVLJANJE SKALE BODOVA
	@RequestMapping(value = "/getKorisnikSkala", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Korisnik getKorisnikSkala(HttpServletRequest request){
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
		Skala skala = skalaRepository.findById(new Long(1)); //trenutno je skala zakucana u bazi
				
		if(k.getUloga().equals("obican")) {
			System.out.println("\n\n\t\t\tobican korisnik...");
			
			if(k.getBrojPoseta() > 0 &&  k.getBrojPoseta() <= skala.getBronzani()) {
				k.setVrstaClana("nema pravo na popust");
				System.out.println("\n\t\t\tnema pravo na popust");
			}else if(k.getBrojPoseta() > skala.getBronzani() && k.getBrojPoseta() <= skala.getSrebrni()) {				
				k.setVrstaClana("bronzani");
				System.out.println("\n\t\t\tbronzani");
			}else if(k.getBrojPoseta() > skala.getSrebrni() && k.getBrojPoseta() <= skala.getZlatni()) {
				k.setVrstaClana("srebrni");
				System.out.println("\n\t\t\tsrebrni");
			}else {
				k.setVrstaClana("zlatni");
				System.out.println("\n\t\t\tzlatni");
			}
				
			korisnikServis.save(k);
			return k;
		}	
		
		return null;
	}
	
}