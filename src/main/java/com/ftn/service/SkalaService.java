package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Adresa;
import com.ftn.model.Skala;

@Service
public interface SkalaService {
	
	Skala findOne(Long id);

	
	Skala save(Skala skala);

}
