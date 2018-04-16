package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Adresa;

@Service
public interface AdresaService {

	Adresa findOne(Long id);

	List<Adresa> findAll();
	
	Adresa save(Adresa adresa);
	
	List<Adresa> save(List<Adresa> adresa);
	
	Adresa delete(Long id);
	
	void delete(List<Long> ids);
}
