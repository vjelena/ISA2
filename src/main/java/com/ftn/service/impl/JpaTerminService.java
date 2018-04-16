package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Sala;
import com.ftn.model.Termin;
import com.ftn.repository.SalaRepository;
import com.ftn.repository.TerminRepository;

@Transactional
@Service
public class JpaTerminService {
	
	@Autowired
	TerminRepository terminRepository;

	
	public Termin nadjiJedanTermin(String id) {
		
		return terminRepository.findOne(new Long(id));
	}
	public List<Termin> nadjiSveTermine() {
		return terminRepository.findAll();
	}

}
