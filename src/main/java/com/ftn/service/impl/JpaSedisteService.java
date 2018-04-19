package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Sediste;
import com.ftn.repository.SedisteRepository;
import com.ftn.service.SedisteService;

@Transactional
@Service
public class JpaSedisteService implements SedisteService{
	
	@Autowired
	private SedisteRepository sedisteRepository;

	@Override
	public Sediste kreirajSediste(Sediste sediste) {
		return sedisteRepository.save(sediste);
	}

	public List<Sediste> nadjiSvaSedista() {
		return sedisteRepository.findAll();
	}

	

	@Override
	public Sediste nadjiJednoSediste(String id) {
		
		return sedisteRepository.findOne(new Long(id));
	}

	
}

