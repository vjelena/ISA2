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

import com.ftn.DTO.BioskopDTO;
import com.ftn.DTO.ProjekcijaDTO;
import com.ftn.DTOconverter.ProjekcijaDTOtoProjekcija;
import com.ftn.model.Adresa;
import com.ftn.model.Bioskop;
import com.ftn.model.Korisnik;
import com.ftn.model.Pozoriste;
import com.ftn.model.Projekcija;
import com.ftn.model.Repertoar;
import com.ftn.repository.BioskopRepository;
import com.ftn.repository.KorisnikRepository;
import com.ftn.service.BioskopService;
import com.ftn.service.PozoristeService;
import com.ftn.service.ProjekcijaService;
import com.ftn.service.impl.JpaBioskopService;
import com.ftn.service.impl.JpaPozoristeService;

@RestController
@RequestMapping(value = "/pozorista")
public class PozoristeController {

	@Autowired
	private JpaPozoristeService jpaPozoristeService;
	
	@Autowired
	private PozoristeService pozoristeService;
	
	

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
	
	
}
