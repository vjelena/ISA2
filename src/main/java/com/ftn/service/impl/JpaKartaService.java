package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Karta;
import com.ftn.repository.KartaRepository;
import com.ftn.service.KartaService;

@Transactional
@Service
public class JpaKartaService implements KartaService{
	
	@Autowired
	private KartaRepository kartaRepository;

	@Override
	public Karta kreirajKartu(Karta karta) {
		return kartaRepository.save(karta);
	}

	public List<Karta> nadjiSveKarte() {
		return kartaRepository.findAll();
	}

	

	@Override
	public Karta nadjiJednuKartu(String id) {
		
		return kartaRepository.findOne(new Long(id));
	}

	@Override
	public void remove(Long id) {
		kartaRepository.delete(id);
		
	}

}

