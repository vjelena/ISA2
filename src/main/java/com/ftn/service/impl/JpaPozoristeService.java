package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
import com.ftn.model.Pozoriste;
import com.ftn.repository.AdresaRepository;
import com.ftn.repository.BioskopRepository;
import com.ftn.repository.PozoristeRepository;
import com.ftn.service.BioskopService;
import com.ftn.service.PozoristeService;

@Transactional
@Service
public class JpaPozoristeService implements PozoristeService{
	
	@Autowired
	private PozoristeRepository pozoristeRepository;
	
	@Autowired
	private AdresaRepository adresaRepository;

	@Override
	public List<Pozoriste> nadjiSvaPozorista() {
		return pozoristeRepository.findAll();
	}
	
	@Override
	public Pozoriste kreirajPozoriste(Pozoriste pozoriste) {
		
		return pozoristeRepository.save(pozoriste);
	}

	
	@Override
	public Pozoriste nadjiJednoPozoriste(String id) {
		
		return pozoristeRepository.findOne(new Long(id));
	}

	@Override
	public Pozoriste save(Pozoriste pozoriste) {
		adresaRepository.save(pozoriste.getAdresa());
		return pozoristeRepository.save(pozoriste);
	}
	

}
