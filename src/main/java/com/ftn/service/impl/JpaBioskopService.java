package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
import com.ftn.repository.BioskopRepository;
import com.ftn.service.BioskopService;

@Transactional
@Service
public class JpaBioskopService implements BioskopService{
	
	@Autowired
	private BioskopRepository bioskopRepository;

	@Override
	public List<Bioskop> nadjiSveBioskope() {
		return bioskopRepository.findAll();
	}
	
	@Override
	public Bioskop kreirajBioskop(Bioskop bioskop) {
		
		return bioskopRepository.save(bioskop);
	}

	
	@Override
	public Bioskop nadjiJedanBioskop(String id) {
		
		return bioskopRepository.findOne(new Long(id));
	}

	



	

}
