package com.ftn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.model.Rekvizit;
import com.ftn.repository.ProdavnicaRepozitorijum;
import com.ftn.repository.RekvizitRepozitorijum;
import com.ftn.service.RekvizitServis;

@Transactional
@Service
public class RekvizitServisImpl implements RekvizitServis{

	@Autowired
	private RekvizitRepozitorijum rekvizitRepozitorijum;
	
	@Autowired
	private ProdavnicaRepozitorijum prodavnicaRepozitorijum;
	
	@Override
	public Rekvizit findOne(Long id) {
		return rekvizitRepozitorijum.findOne(id);
	}

	@Override
	public List<Rekvizit> findAll() {
		return rekvizitRepozitorijum.findAll();
	}

	@Override
	public Rekvizit save(Rekvizit rekvizit) {
		if(rekvizit.getProdavnica() == null){
			rekvizit.setProdavnica(prodavnicaRepozitorijum.findOne((long) 1));
		}
		return rekvizitRepozitorijum.save(rekvizit);
	}

	@Override
	public List<Rekvizit> save(List<Rekvizit> rekviziti) {
		return rekvizitRepozitorijum.save(rekviziti);
	}

	@Override
	public Rekvizit delete(Long id) {
		Rekvizit rekvizit = rekvizitRepozitorijum.findOne(id);
		if(rekvizit == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant rekvizit");
		}
		rekvizitRepozitorijum.delete(rekvizit);
		return rekvizit;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}
