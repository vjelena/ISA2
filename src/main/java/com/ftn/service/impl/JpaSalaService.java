package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.model.Sala;
import com.ftn.repository.SalaRepository;
import com.ftn.service.SalaService;

@Transactional
@Service
public class JpaSalaService implements SalaService {
	
	@Autowired
	SalaRepository salaRepository;

	@Override
	public Sala azurirajKonfiguraciju(Sala sala) {
		return salaRepository.save(sala);
		
	}
	public Sala nadjiJednuSalu(String id) {
		return salaRepository.findOne(new Long(id));
	}
	public List<Sala> nadjiSveSale() {
		return salaRepository.findAll();
	}
	
	
	public Sala kreirajSalu(Sala sala) {
		return salaRepository.save(sala);
	}

	@Override
	public Sala save(Sala sala) {
		return salaRepository.save(sala);
	}
	
}
