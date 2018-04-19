package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.IzvestajOPoslovanju;
import com.ftn.repository.IzvjestajRepository;
import com.ftn.service.IzvjestajService;

@Transactional
@Service
public class JpaIzvjestajService implements IzvjestajService{
	
	@Autowired
	private IzvjestajRepository izvjestajRepository;

	@Override
	public IzvestajOPoslovanju kreirajIzvjestaj(IzvestajOPoslovanju izvjestaj) {
		return izvjestajRepository.save(izvjestaj);
	}

	public List<IzvestajOPoslovanju> nadjiSveIzvjestaje() {
		return izvjestajRepository.findAll();
	}

	

	@Override
	public IzvestajOPoslovanju nadjiJedanIzvjestaj(String id) {
		
		return izvjestajRepository.findOne(new Long(id));
	}

	

}
