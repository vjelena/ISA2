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
import com.ftn.model.Projekcija;
import com.ftn.model.Repertoar;
import com.ftn.repository.BioskopRepository;
import com.ftn.repository.KorisnikRepository;
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
	
	@Autowired
	private BioskopRepository bioskopRepository;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	

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
		Projekcija projekcija = projekcijaService.save(toProjekcija.convert(projekcijaDTO));
		return new ResponseEntity<>(projekcija, HttpStatus.OK);
	}
	
	
	
	//BS
	//pretraga bioskopa
	@RequestMapping(value = "/pretraziBioskope/{naziv}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bioskop>> pretraziBioskope(@PathVariable String naziv, HttpServletRequest request){
		System.out.println("\n\t\tBioskopController: pretraziBioskope\n");
		
		if(naziv.equals("nemaUnosa"))
			return new ResponseEntity<>(bioskopRepository.findAll(), HttpStatus.OK);
		else
			return new ResponseEntity<>(bioskopRepository.findByNazivIgnoreCaseContaining(naziv), HttpStatus.OK);
	}
	
	//preuzimanje projekcija koje su na repertoaru selektovanog bioskopa
	@RequestMapping(value = "/projekcijeIzRepertoaraSelektovanogBioskopa/{naziv}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Projekcija>> projekcijeIzRepertoaraSelektovanogBioskopa(@PathVariable String naziv) {
		Bioskop bioskop = bioskopRepository.findByNaziv(naziv);
	
		if (bioskop == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(bioskop.getRepertoar().getProjekcije(), HttpStatus.OK);
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	//TODO: ajax!!! -> kada uradis rezervaciju mesta u bioskopu
	//dodavanje posecenih bioskopa i posetilaca u liste
	@RequestMapping(value = "/dodajPosecene/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bioskop> dodajPosecene(@PathVariable Long id, HttpServletRequest request) {
		System.out.println("\n\t\tPrikazBioskopa kontroler: dodajPosecene\n");
		
		Korisnik k = (Korisnik)request.getSession().getAttribute("aktivanKorisnik");
		Korisnik posetilac = korisnikRepository.findById(k.getId());
		Bioskop posecenBioskop = bioskopRepository.findById(id);
		
		posetilac.getPoseceniBioskopi().add(posecenBioskop);
		posecenBioskop.getPosetioci().add(posetilac);
		
		korisnikRepository.save(posetilac);
		bioskopRepository.save(posecenBioskop);
		
		return new ResponseEntity<>(posecenBioskop, HttpStatus.OK);	
	}
	//------------------------------------------------------------------------------------------------------------------------

}
