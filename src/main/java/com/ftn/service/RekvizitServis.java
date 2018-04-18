package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Rekvizit;

@Service
public interface RekvizitServis {

	Rekvizit findOne(Long id);

	List<Rekvizit> findAll();
	
	Rekvizit save(Rekvizit rekvizit);
	
	List<Rekvizit> save(List<Rekvizit> rekviziti);
	
	Rekvizit delete(Long id);
	
	void delete(List<Long> ids);
}
