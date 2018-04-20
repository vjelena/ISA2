package com.ftn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.model.ObicnaRezervacijaPozoriste;
import com.ftn.repository.ObicnaRezervacijaPozoristeRepository;
import com.ftn.repository.ObicnaRezervacijaRepository;
import com.ftn.service.ObicnaRezervacijaPozoristeServis;
import com.ftn.service.ObicnaRezervacijaServis;

@Transactional
@Service
public class JpaObicnaRezervacijaPozoristeService implements ObicnaRezervacijaPozoristeServis {

	@Autowired
	private ObicnaRezervacijaPozoristeRepository obicnaRezervacijaPozoristeRepository;
	

	@Override
	public ObicnaRezervacijaPozoriste save(ObicnaRezervacijaPozoriste obicnaRezervacijaPozoriste) {
		return obicnaRezervacijaPozoristeRepository.save(obicnaRezervacijaPozoriste);
	}
	
	@Override
	public List<ObicnaRezervacijaPozoriste> findAll() {
		return obicnaRezervacijaPozoristeRepository.findAll();
	}
	
}
