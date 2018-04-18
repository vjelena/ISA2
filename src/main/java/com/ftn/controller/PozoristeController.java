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
import com.ftn.model.Pozoriste;
import com.ftn.model.ProjekcijaPozorista;
import com.ftn.repository.KorisnikRepository;
import com.ftn.repository.PozoristeRepository;
import com.ftn.service.PozoristeService;
import com.ftn.service.impl.JpaPozoristeService;

@RestController
@RequestMapping(value = "/pozorista")
public class PozoristeController {

	@Autowired
	private JpaPozoristeService jpaPozoristeService;
	
	@Autowired
	private PozoristeService pozoristeService;
	
	@Autowired
	private PozoristeRepository pozoristeRepository;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	

	@RequestMapping(value = "/prikaziPozorista", method = RequestMethod.GET)
	public ResponseEntity<List<Pozoriste>> prikaziBioskope() {
		List<Pozoriste> pozorista = jpaPozoristeService.nadjiSvaPozorista();
		return new ResponseEntity<>(pozorista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pozoriste> nadjiPozoriste(@PathVariable String id) {
		Pozoriste pozoriste = jpaPozoristeService.nadjiJednoPozoriste(id);
		if (pozoriste == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pozoriste, HttpStatus.OK);
	}
	
	
	
	
	//BS
	//pretraga pozorista
	@RequestMapping(value = "/pretraziPozorista/{naziv}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pozoriste>> pretraziPozorista(@PathVariable String naziv, HttpServletRequest request){
		if(naziv.equals("nemaUnosa"))
			return new ResponseEntity<>(pozoristeRepository.findAll(), HttpStatus.OK);
		else
			return new ResponseEntity<>(pozoristeRepository.findByNazivIgnoreCaseContaining(naziv), HttpStatus.OK);
	}
		
	//preuzimanje projekcija koje su na repertoaru selektovanog pozorista
	@RequestMapping(value = "/projekcijeIzRepertoaraSelektovanogPozorista/{naziv}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProjekcijaPozorista>> projekcijeIzRepertoaraSelektovanogPozorista(@PathVariable String naziv) {
		Pozoriste pozoriste = pozoristeRepository.findByNaziv(naziv);
		
		if (pozoriste == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<>(pozoriste.getRepertoarPozorista().getProjekcijePozorista(), HttpStatus.OK);
	}
		
	//------------------------------------------------------------------------------------------------------------------------
	//TODO: ajax!!! -> kada uradis rezervaciju mesta u pozoristu
	//dodavanje posecenih pozorista i posetilaca u liste
	@RequestMapping(value = "/dodajPosecene/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pozoriste> dodajPosecene(@PathVariable Long id, HttpServletRequest request) {
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
		Korisnik posetilac = korisnikRepository.findById(k.getId());
		Pozoriste posecenoPozoriste = pozoristeRepository.findById(id);
			
		posetilac.getPosecenaPozorista().add(posecenoPozoriste);
		posecenoPozoriste.getPosetiociPozorista().add(posetilac);
			
		korisnikRepository.save(posetilac);
		pozoristeRepository.save(posecenoPozoriste);
			
		return new ResponseEntity<>(posecenoPozoriste, HttpStatus.OK);	
	}
	//------------------------------------------------------------------------------------------------------------------------

}
