package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Rekvizit;

@Service
public interface RekvizitServis {

	Rekvizit findOne(Long id);

	List<Rekvizit> findAll();
	
	Rekvizit save(Rekvizit oglas);
	
	List<Rekvizit> save(List<Rekvizit> oglasi);
	
	Rekvizit delete(Long id);
	
	void delete(List<Long> ids);
}
