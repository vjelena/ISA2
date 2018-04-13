package com.ftn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
import com.ftn.model.Projekcija;
import com.ftn.repository.BioskopRepository;
import com.ftn.repository.ProjekcijaRepository;
import com.ftn.service.BioskopService;
import com.ftn.service.ProjekcijaService;

@Transactional
@Service
public class JpaProjekcijaService implements ProjekcijaService {
	@Autowired
	private ProjekcijaRepository projekcijaRepository;
	
	@Override
	public Projekcija nadjiJednuProjekciju(String id) {
		return projekcijaRepository.findOne(new Long(id));
	}

	@Override
	public Projekcija save(Projekcija projekcija) {
		return projekcijaRepository.save(projekcija);
	}





}
