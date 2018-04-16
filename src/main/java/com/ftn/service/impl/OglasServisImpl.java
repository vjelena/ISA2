package com.ftn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.model.Oglas;
import com.ftn.repository.FanZonaRepozitorijum;
import com.ftn.repository.OglasRepozitorijum;
import com.ftn.service.FanZonaServis;
import com.ftn.service.OglasServis;


@Transactional
@Service
public class OglasServisImpl implements OglasServis{

	@Autowired
	private OglasRepozitorijum oglasRepozitorijum;
	
	@Autowired
	private FanZonaRepozitorijum fanZonaRepozitorijum;
	
	@Override
	public Oglas findOne(Long id) {
		return oglasRepozitorijum.findOne(id);
	}

	@Override
	public List<Oglas> findAll() {
		return oglasRepozitorijum.findAll();
	}

	@Override
	public Oglas save(Oglas oglas) {
		if(oglas.getFanZona() == null){
			oglas.setStatus(0);
			oglas.setFanZona(fanZonaRepozitorijum.findOne((long) 1));
		}
		return oglasRepozitorijum.save(oglas);
	}

	@Override
	public List<Oglas> save(List<Oglas> oglasi) {
		return oglasRepozitorijum.save(oglasi);
	}

	@Override
	public Oglas delete(Long id) {
		Oglas oglas = oglasRepozitorijum.findOne(id);
		if(oglas == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant oglas");
		}
		oglasRepozitorijum.delete(oglas);
		return oglas;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
