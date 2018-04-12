package com.ftn.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
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
		System.out.println("=================== id bioskopa za pretragu: " + id);
		return salaRepository.findOne(new Long(id));
	}
	
}
