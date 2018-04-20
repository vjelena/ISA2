package com.ftn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Bioskop;
import com.ftn.model.Korisnik;
import com.ftn.model.ObicnaRezervacijaPozoriste;
import com.ftn.model.Pozoriste;
import com.ftn.repository.KorisnikRepository;
import com.ftn.repository.ObicnaRezervacijaPozoristeRepository;
import com.ftn.repository.PozoristeRepository;
import com.ftn.service.ObicnaRezervacijaPozoristeServis;

@RestController
@RequestMapping(value = "/obicnaRezervacijaPozoriste")
public class ObicnaRezervacijaPozoristeController {

	@Autowired
	private ObicnaRezervacijaPozoristeServis obicnaRezervacijaPozoristeServis;
	
	@Autowired
	private ObicnaRezervacijaPozoristeRepository obicnaRezervacijaPozoristeRepository;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private PozoristeRepository pozoristeRepository;
	
	
	//preuzimanje svih rezervacija
	@RequestMapping(value="/getObicneRezervacije", method = RequestMethod.GET)
	public ResponseEntity<List<ObicnaRezervacijaPozoriste>> getKorisnici() {
		List<ObicnaRezervacijaPozoriste> obicneRezervacije = obicnaRezervacijaPozoristeServis.findAll();
			
		if(obicneRezervacije.equals(null)) {
			return new ResponseEntity<>(obicneRezervacije, HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<>(obicneRezervacije, HttpStatus.OK);
	}
	
	
	//cuvanje obicne rezervacije (bez prijatelja)
	@RequestMapping(value = "/sacuvajObicnuRezervacijuBezPrijatelja/{nazivSelektovanogBioskopa}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovaneSale}/{selektovanaSedista}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ObicnaRezervacijaPozoriste> sacuvajObicnuRezervacijuBezPrijatelja(@PathVariable String nazivSelektovanogBioskopa, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovaneSale, @PathVariable String selektovanaSedista, HttpServletRequest request) {
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik posetilac = korisnikRepository.findById(k.getId());
		
		ObicnaRezervacijaPozoriste obicnaRezervacija = new ObicnaRezervacijaPozoriste(nazivSelektovanogBioskopa, nazivSelektovaneProjekcije, nazivSelektovanogTermina, nazivSelektovaneSale, selektovanaSedista);
		
		Pozoriste posecenoPozoriste = pozoristeRepository.findByNaziv(nazivSelektovanogBioskopa);		
		posetilac.getPosecenaPozorista().add(posecenoPozoriste);
		System.out.println("\n\t\t\tdodat poseceno pozoriste: " + posecenoPozoriste.getId() + ", " + posecenoPozoriste.getNaziv());
		/*posetilac.getListaObicnihRezervacija().add(obicnaRezervacija);
		System.out.println("\n\t\t\tdodata napravljena rezervacija: " + obicnaRezervacija.getId());*/
		korisnikRepository.save(posetilac);
		
		System.out.println("\n\n\n\t\t\tpre save obicnaRezervacija");
		obicnaRezervacijaPozoristeServis.save(obicnaRezervacija);
		System.out.println("\n\n\n\t\t\tposle save obicnaRezervacija");
				
		return new ResponseEntity<ObicnaRezervacijaPozoriste>(obicnaRezervacija, HttpStatus.OK);
	}
	
	//cuvanje obicne rezervacije (sa prijateljem)
	@RequestMapping(value = "/sacuvajObicnuRezervacijuSaPrijateljem/{nazivSelektovanogBioskopa}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovaneSale}/{selektovanaSedista}/{nazivSelektovanogPrijatelja}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ObicnaRezervacijaPozoriste> sacuvajObicnuRezervacijuSaPrijateljem(@PathVariable String nazivSelektovanogBioskopa, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovaneSale, @PathVariable String selektovanaSedista, @PathVariable String nazivSelektovanogPrijatelja, HttpServletRequest request) {
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik posetilac = korisnikRepository.findById(k.getId());
						
		ObicnaRezervacijaPozoriste obicnaRezervacija = new ObicnaRezervacijaPozoriste(nazivSelektovanogBioskopa, nazivSelektovaneProjekcije, nazivSelektovanogTermina, nazivSelektovaneSale, selektovanaSedista, nazivSelektovanogPrijatelja);
		
		Pozoriste posecenoPozoriste = pozoristeRepository.findByNaziv(nazivSelektovanogBioskopa);		
		posetilac.getPosecenaPozorista().add(posecenoPozoriste);
		System.out.println("\n\t\t\tdodato poseceno pozoriste: " + posecenoPozoriste.getId() + ", " + posecenoPozoriste.getNaziv());
		/*posetilac.getListaObicnihRezervacija().add(obicnaRezervacija);
		System.out.println("\n\t\t\tdodata napravljena rezervacija: " + obicnaRezervacija.getId());*/
		korisnikRepository.save(posetilac);
		
		System.out.println("\n\n\n\t\t\tpre save obicnaRezervacija");
		obicnaRezervacijaPozoristeServis.save(obicnaRezervacija);
		System.out.println("\n\n\n\t\t\tposle save obicnaRezervacija");
		
	    return new ResponseEntity<ObicnaRezervacijaPozoriste>(obicnaRezervacija, HttpStatus.OK);
	 }
	
	
	//otkazivanje rezervacije
	@RequestMapping(value = "/otkaziRezervaciju/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean otkaziRezervaciju(@PathVariable Long id, HttpServletRequest request){		
		System.out.println("\n\t\t\tObicnaRezervacijaPozoristeController: otkaziRezervaciju -> NIJE IMPLEMENTIRANO DO KRAJA");		
		
		/*Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik posetilac = korisnikRepository.findById(k.getId());
		
		System.out.println("\n\t\t\tid preko zahteva: " + id);
		
		for(int i = 0; i < posetilac.getListaObicnihRezervacija().size(); i++) {
			System.out.println("\n\t\t\tsvi id-evi iz liste: " + posetilac.getListaObicnihRezervacija().get(i).getId());
		}
		
		for(int i = 0; i < posetilac.getListaObicnihRezervacija().size(); i++) {
			if(posetilac.getListaObicnihRezervacija().get(i).getId().equals(id)) {
				System.out.println("\n\t\t\tobrisana rezervacija: " + posetilac.getListaObicnihRezervacija().get(i));
				posetilac.getListaObicnihRezervacija().remove(i);
			}
		}
		
		korisnikRepository.save(posetilac);*/
		
		return true;
	}
	
}
