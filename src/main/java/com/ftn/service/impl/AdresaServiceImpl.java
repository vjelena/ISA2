package com.ftn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.model.Adresa;
import com.ftn.repository.AdresaRepository;
import com.ftn.service.AdresaService;

@Transactional
@Service
public class AdresaServiceImpl implements AdresaService{

	@Autowired
	private AdresaRepository adresaRepository;
	
	public Adresa findOne(Long id) {
		return adresaRepository.findOne(id);
	}

	public List<Adresa> findAll() {
		return adresaRepository.findAll();
	}

	public Adresa save(Adresa adresa) {
		return adresaRepository.save(adresa);
	}

	public List<Adresa> save(List<Adresa> adresa) {
		return adresaRepository.save(adresa);
	}

	public Adresa delete(Long id) {
		Adresa adresa = adresaRepository.findOne(id);
		if(adresa == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant adresa");
		}
		adresaRepository.delete(adresa);
		return adresa;
	}

	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
