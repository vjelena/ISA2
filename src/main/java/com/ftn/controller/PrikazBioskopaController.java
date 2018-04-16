package com.ftn.controller;

import java.util.List;

import org.apache.tomcat.jni.BIOCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ftn.DTO.BioskopDTO;
import com.ftn.DTO.ProjekcijaDTO;
import com.ftn.DTOconverter.ProjekcijaDTOtoProjekcija;
import com.ftn.model.Adresa;
import com.ftn.model.Bioskop;
import com.ftn.model.Korisnik;
import com.ftn.model.Oglas;
import com.ftn.model.Projekcija;
import com.ftn.model.Sala;
import com.ftn.service.BioskopService;
import com.ftn.service.ProjekcijaService;
import com.ftn.service.impl.JpaBioskopService;

@RestController
@RequestMapping(value = "/bioskopi")
public class PrikazBioskopaController {

	@Autowired
	private JpaBioskopService jpaBioskopService;
	
	@Autowired
	private BioskopService bioskopService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private ProjekcijaDTOtoProjekcija toProjekcija;
	
	

	@RequestMapping(value = "/prikaziBioskope", method = RequestMethod.GET)
	public ResponseEntity<List<Bioskop>> prikaziBioskope() {
		List<Bioskop> bioskopi = jpaBioskopService.nadjiSveBioskope();
		return new ResponseEntity<>(bioskopi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bioskop> nadjiBioskop(@PathVariable String id) {
		Bioskop bioskop = jpaBioskopService.nadjiJedanBioskop(id);
		if (bioskop == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bioskop, HttpStatus.OK);
	}
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/bioskopi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bioskop>> dodajBioskop(@RequestBody Bioskop bioskop) {
		jpaBioskopService.kreirajBioskop(bioskop);
		return new ResponseEntity<>(jpaBioskopService.nadjiSveBioskope(), HttpStatus.OK);
	}
	
	
	/*@RequestMapping(value="/izmjeniBioskop", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean izmjeniBioskop(@RequestBody Bioskop bioskop, HttpServletRequest request) {
		
		Bioskop b = bioskop; 
		b.setId(new Long(bioskop.getId())); 
		
		b.setNaziv(bioskop.getNaziv());
		b.setOpis(bioskop.getOpis());
		b.setAdresa(bioskop.getAdresa());
		
		jpaBioskopService.save(b);
		return true;
	}*/
	
	
/*	@RequestMapping(value = "/izmjeniBioskop/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bioskop> izmjeniBioskop(@PathVariable Long id, @PathVariable Bioskop b) {
		
		Bioskop bioskop = jpaBioskopService.nadjiJedanBioskop(id);
			
		bioskop.setNaziv(b.getNaziv());
		bioskop.setAdresa(b.getAdresa());
		bioskop.setOpis(b.getOpis());

		bioskop = jpaBioskopService.save(bioskop);
		if (bioskop== null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bioskop, HttpStatus.OK);
	}*/
	
	
	@RequestMapping(value = "izmjeniBioskop/{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Bioskop> izmjeniBioskop(@RequestBody BioskopDTO bioskopDTO,@PathVariable Long id) {
		System.out.println("Bioskoppppppppppppp:" + bioskopDTO);
		Bioskop bioskop = jpaBioskopService.nadjiJedanBioskop(Long.toString(id));
			bioskop.setNaziv(bioskopDTO.getNaziv());
			bioskop.setOpis(bioskopDTO.getOpis());
			
			Adresa adresa = new Adresa(bioskopDTO.getUlica(), bioskopDTO.getBroj(), bioskopDTO.getGrad());
			bioskop.setAdresa(adresa);
			
			jpaBioskopService.save(bioskop);
			return new ResponseEntity<>(bioskop, HttpStatus.OK);
		}
	
	
	
	@RequestMapping(value = "/dodajprojekciju/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Projekcija> dodajProjekciju(@PathVariable String id, @RequestBody ProjekcijaDTO projekcijaDTO) {
		System.out.println(">>>>>>> " + projekcijaDTO);
		Projekcija projekcija = projekcijaService.save(toProjekcija.convert(projekcijaDTO));
		return new ResponseEntity<>(projekcija, HttpStatus.OK);
	}

}
