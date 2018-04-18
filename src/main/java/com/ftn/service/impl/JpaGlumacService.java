package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Film;
import com.ftn.model.Glumac;
import com.ftn.repository.FilmRepository;
import com.ftn.repository.GlumacRepository;
import com.ftn.service.FilmService;
import com.ftn.service.GlumacService;

@Transactional
@Service
public class JpaGlumacService implements GlumacService{
	
	@Autowired
	private GlumacRepository glumacRepository;

	@Override
	public Glumac kreirajGlumca(Glumac glumac) {
		return glumacRepository.save(glumac);
	}

	public List<Glumac> nadjiSveGlumce() {
		return glumacRepository.findAll();
	}

	
	@Override
	public Glumac nadjiJednogGlumca(String id) {
		
		return glumacRepository.findOne(new Long(id));
	}
	

}
