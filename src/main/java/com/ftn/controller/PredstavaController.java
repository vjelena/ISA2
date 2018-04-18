package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Predstava;
import com.ftn.service.PredstavaService;
import com.ftn.service.impl.JpaPredstavaService;

@RestController
@RequestMapping(value = "/predstava")
public class PredstavaController {
	
	@Autowired
	private JpaPredstavaService jpaPredstavaService;
	
	@Autowired
	private PredstavaService predstavaService;
	

	@RequestMapping(value = "/getPredstave", method = RequestMethod.GET)
	public ResponseEntity<List<Predstava>> prikaziPredstave() {
		List<Predstava> predstave = jpaPredstavaService.nadjiSvePredstave();
		return new ResponseEntity<>(predstave, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Predstava> nadjiPredstavu(@PathVariable String id) {
		Predstava predstava = jpaPredstavaService.nadjiJednuPredstavu(id);
		if (predstava == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(predstava, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajFilm", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Predstava> dodajFilm(@RequestBody Predstava predstava) {
		Predstava novaPredstava = jpaPredstavaService.kreirajPredstavu(predstava);
		return new ResponseEntity<>(novaPredstava, HttpStatus.OK);
	}

}