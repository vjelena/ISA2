package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Predstava;

@Service
public interface PredstavaService {

	
public List<Predstava> nadjiSvePredstave();
	
	
	public Predstava kreirajPredstavu(Predstava predstava);


	public Predstava nadjiJednuPredstavu(String id);
}
