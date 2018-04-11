package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTO.OglasDTO;
import com.ftn.DTOconverter.OglasDTOtoOglas;
import com.ftn.DTOconverter.OglasToOglasDTO;
import com.ftn.model.Oglas;
import com.ftn.service.OglasServis;

@RestController
@RequestMapping(value = "/oglas")
public class OglasKontroler {

	@Autowired
	private OglasServis oglasServis;
	
	@Autowired
	private OglasDTOtoOglas toOglas;
	
	@Autowired
	private OglasToOglasDTO toOglasDTO;
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<OglasDTO> addOglas(@RequestBody OglasDTO oglasDTO){
		Oglas noviOglas = oglasServis.save(toOglas.convert(oglasDTO));
		//System.out.println("**************************"+oglasDTO.getNaziv());
		
		return new ResponseEntity<>(toOglasDTO.convert(noviOglas), HttpStatus.OK);
	}	
	
	@RequestMapping(value="getOglasi", method = RequestMethod.GET)
	public ResponseEntity<List<OglasDTO>> getOglasi() {
		List<Oglas> oglasi = oglasServis.findAll();
		return new ResponseEntity<>(toOglasDTO.convert(oglasi), HttpStatus.OK);
	}
}