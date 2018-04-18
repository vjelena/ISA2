package com.ftn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.model.Ponuda;
import com.ftn.repository.PonudaRepozitorijum;
import com.ftn.service.PonudaServis;

@Transactional
@Service
public class PonudaServisImpl implements PonudaServis{

	@Autowired
	private PonudaRepozitorijum ponudaRepozitorijum;
	
	@Override
	public Ponuda findOne(Long id) {
		return ponudaRepozitorijum.findOne(id);
	}

	@Override
	public List<Ponuda> findAll() {
		return ponudaRepozitorijum.findAll();
	}

	@Override
	public Ponuda save(Ponuda ponuda) {
		return ponudaRepozitorijum.save(ponuda);
	}

	@Override
	public List<Ponuda> save(List<Ponuda> ponude) {
		return ponudaRepozitorijum.save(ponude);
	}

	@Override
	public Ponuda delete(Long id) {
		Ponuda ponuda = ponudaRepozitorijum.findOne(id);
		if(ponuda == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant ponuda");
		}
		ponudaRepozitorijum.delete(ponuda);
		return ponuda;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}
