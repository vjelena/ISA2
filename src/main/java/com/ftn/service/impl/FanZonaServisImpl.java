package com.ftn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.model.FanZona;
import com.ftn.repository.FanZonaRepozitorijum;
import com.ftn.service.FanZonaServis;

@Transactional
@Service
public class FanZonaServisImpl implements FanZonaServis{

	@Autowired
	private FanZonaRepozitorijum fanZonaRepozitorijum;
	
	@Override
	public FanZona findOne(Long id) {
		return fanZonaRepozitorijum.findOne(id);
	}

	@Override
	public List<FanZona> findAll() {
		return fanZonaRepozitorijum.findAll();
	}

	@Override
	public FanZona save(FanZona fanZona) {
		return fanZonaRepozitorijum.save(fanZona);
	}

	@Override
	public List<FanZona> save(List<FanZona> fanZone) {
		return fanZonaRepozitorijum.save(fanZone);
	}

	@Override
	public FanZona delete(Long id) {
		FanZona fanZona = fanZonaRepozitorijum.findOne(id);
		if(fanZona == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant fanZona");
		}
		fanZonaRepozitorijum.delete(fanZona);
		return fanZona;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

	
}
