package com.ftn.service;

import org.springframework.stereotype.Service;

import com.ftn.model.Projekcija;


@Service
public interface ProjekcijaService {

	public Projekcija nadjiJednuProjekciju(String id);
	
	public Projekcija save(Projekcija projekcija);

	

}
