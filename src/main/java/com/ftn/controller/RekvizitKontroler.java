package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Rekvizit;
import com.ftn.service.RekvizitServis;

@RestController
@RequestMapping(value = "/rekvizit")
public class RekvizitKontroler {

	@Autowired
	private RekvizitServis rekvizitServis;
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Rekvizit> addRekvizit(@RequestBody Rekvizit rekvizit){
		Rekvizit noviRekvizit = rekvizitServis.save(rekvizit);
		return new ResponseEntity<>(noviRekvizit, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/getRekviziti", method = RequestMethod.GET)
	public ResponseEntity<List<Rekvizit>> getRekviziti() {
		List<Rekvizit> rekviziti = rekvizitServis.findAll();
		return new ResponseEntity<>(rekviziti, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Rekvizit> delete(@PathVariable Long id) {
		System.out.println("************"+id);
		Rekvizit deleted = rekvizitServis.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
}
