package com.ftn.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTO.BioskopDTO;
import com.ftn.model.Adresa;
import com.ftn.model.Bioskop;
import com.ftn.model.BrzaKarta;
import com.ftn.model.IzvestajOPoslovanju;
import com.ftn.model.Karta;
import com.ftn.model.Korisnik;
import com.ftn.model.Repertoar;
import com.ftn.model.Sala;
import com.ftn.service.FanZonaServis;
import com.ftn.service.KorisnikService;
import com.ftn.service.impl.JpaBioskopService;

@RestController
@RequestMapping(value = "/admin")
public class AdminSistemaKontroler {

	@Autowired
	private FanZonaServis fanZonaServis;
	
	@Autowired
	private JpaBioskopService jpaBioskopService;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajBioskop", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bioskop> dodajBioskop(@RequestBody BioskopDTO bioskopDTO) {
		Bioskop noviBioskop = new Bioskop();
		System.out.println("*****"+bioskopDTO.toString());
		Adresa adresa = new Adresa(bioskopDTO.getAdresaUlica(), bioskopDTO.getAdresaBroj(), bioskopDTO.getAdresaGrad());
		
		noviBioskop.setNaziv(bioskopDTO.getNaziv());
		noviBioskop.setOpis(bioskopDTO.getOpis());
		noviBioskop.setProsecnaOcena(bioskopDTO.getProsecnaOcena());
		noviBioskop.setFanZona(fanZonaServis.findOne((long) 1));
		noviBioskop.setAdresa(adresa);
		noviBioskop.setRepertoar(new Repertoar());
		noviBioskop.setIzvestaj(new IzvestajOPoslovanju());
		noviBioskop.setBrzeKarte(new HashSet<BrzaKarta>());
		noviBioskop.setListaKarata(new HashSet<Karta>());
		noviBioskop.setListaSala(new HashSet<Sala>());
		
		jpaBioskopService.save(noviBioskop);		
		return new ResponseEntity<>(noviBioskop, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajAdmina", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> dodajAdmina(@RequestBody Korisnik korisnik) {
		System.out.println(korisnik.toString());
		Korisnik k = new Korisnik(korisnik.getEmail(), korisnik.getLozinka(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getAdresa(), korisnik.getBrojTelefona(), korisnik.getUloga(), true, false);
		
		for(Korisnik kor : korisnikServis.findAll()) {
			if(!kor.getEmail().equals(k.getEmail())) {
				if(!k.getEmail().isEmpty() && !k.getLozinka().isEmpty() && !k.getIme().isEmpty() && !k.getPrezime().isEmpty() && !k.getAdresa().getUlica().toString().isEmpty() && !k.getAdresa().getBroj().toString().isEmpty() && !k.getAdresa().getGrad().toString().isEmpty() && !k.getBrojTelefona().isEmpty()) {
					korisnikServis.save(k);
					return new ResponseEntity<Korisnik>(k, HttpStatus.OK);
				}
			}else{
				System.out.println("ISTI EMAIL");
			}
		}
		
		return new ResponseEntity<Korisnik>(k, HttpStatus.BAD_REQUEST);
	}
}
