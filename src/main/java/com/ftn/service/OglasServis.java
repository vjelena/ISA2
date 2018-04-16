package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Oglas;

@Service
public interface OglasServis {

	Oglas findOne(Long id);

	List<Oglas> findAll();
	
	Oglas save(Oglas oglas);
	
	List<Oglas> save(List<Oglas> oglasi);
	
	Oglas delete(Long id);
	
	void delete(List<Long> ids);
}
