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

import com.ftn.DTO.ProjekcijaDTO;
import com.ftn.DTOconverter.ProjekcijaDTOtoProjekcija;
import com.ftn.model.Projekcija;
import com.ftn.model.Termin;
import com.ftn.repository.ProjekcijaRepository;
import com.ftn.service.ProjekcijaService;
import com.ftn.service.impl.JpaFilmService;
import com.ftn.service.impl.JpaProjekcijaService;
import com.ftn.service.impl.JpaSalaService;
import com.ftn.service.impl.JpaTerminService;

@RestController
@RequestMapping(value = "/projekcija")
public class ProjekcijaController {
	
	@Autowired
	private JpaProjekcijaService jpaProjekcijaService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private JpaFilmService jpaFilmService;
	
	@Autowired
	private JpaTerminService jpaTerminService;
	
	@Autowired
	private JpaSalaService jpaSalaService;
	
	@Autowired
	private ProjekcijaDTOtoProjekcija toProjekcija;
	
	
	@Autowired
	private ProjekcijaRepository projekcijaRepository;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Projekcija> nadjiProjekciju(@PathVariable String id) {
		System.out.println("=================>>>>> Prije nadjiJedanBioskop:" + id);
		Projekcija projekcija = jpaProjekcijaService.nadjiJednuProjekciju(id);
		if (projekcija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Bice prikazan: " + projekcija.getCena());
		return new ResponseEntity<>(projekcija, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/izbrisiProjekciju/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void izbrisiProjekciju(@PathVariable Long id, HttpServletRequest request){
		projekcijaService.remove(id);
	}
	
	
	@RequestMapping(value = "izmjeniProjekciju/{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Projekcija> izmjeniProjekciju(@RequestBody ProjekcijaDTO projekcijaDTO,@PathVariable Long id) {
		
		Projekcija projekcija = toProjekcija.convert(projekcijaDTO);
		projekcija.setId(new Long(id));
	
		jpaProjekcijaService.save(projekcija);
		return new ResponseEntity<>(projekcija, HttpStatus.OK);
	}
	//BS
	//preuzimanje termina u kojima se odrzavaju projekcije koje su na repertoaru selektovanog bioskopa
	@RequestMapping(value = "/preuzmiTermineZaSelektovanuProjekciju/{naziv}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Termin> preuzmiTermineZaSelektovanuProjekciju(@PathVariable String naziv) {
		Projekcija projekcija = projekcijaRepository.findByFilm(naziv);
		
		if (projekcija == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
			
		System.out.println("\n\t\t\tpovratna vrednost ProjekcijaController preuzmiTermineZaSelektovanuProjekciju/{naziv}:\t" + projekcija.getTermin());
		return new ResponseEntity<>(projekcija.getTermin(), HttpStatus.OK);

	}
}
