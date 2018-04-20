package com.ftn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.model.ObicnaRezervacija;
import com.ftn.repository.ObicnaRezervacijaRepository;
import com.ftn.service.ObicnaRezervacijaServis;

@Transactional
@Service
public class JpaObicnaRezervacijaService  implements ObicnaRezervacijaServis {

	@Autowired
	private ObicnaRezervacijaRepository obicnaRezervacijaRepository;
	
	@Override
	public ObicnaRezervacija save(ObicnaRezervacija obicnaRezervacija) {
		return obicnaRezervacijaRepository.save(obicnaRezervacija);
	}

	@Override
	public List<ObicnaRezervacija> findAll() {
		return obicnaRezervacijaRepository.findAll();
	}

}
