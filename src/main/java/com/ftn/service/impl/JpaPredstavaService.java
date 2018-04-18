package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Predstava;
import com.ftn.repository.PredstavaRepository;
import com.ftn.service.PredstavaService;

@Transactional
@Service
public class JpaPredstavaService implements PredstavaService{
	
	@Autowired
	private PredstavaRepository predstavaRepository;

	@Override
	public Predstava kreirajPredstavu(Predstava predstava) {
		return predstavaRepository.save(predstava);
	}

	public List<Predstava> nadjiSvePredstave() {
		return predstavaRepository.findAll();
	}

	

	@Override
	public Predstava nadjiJednuPredstavu(String id) {
		
		return predstavaRepository.findOne(new Long(id));
	}

}
