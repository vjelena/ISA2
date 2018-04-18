package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Ponuda;

@Service
public interface PonudaServis {

	Ponuda findOne(Long id);

	List<Ponuda> findAll();
	
	Ponuda save(Ponuda ponuda);
	
	List<Ponuda> save(List<Ponuda> ponude);
	
	Ponuda delete(Long id);
	
	void delete(List<Long> ids);
}
