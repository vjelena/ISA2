package com.ftn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ftn.model.Bioskop;
import com.ftn.repository.BioskopRepository;
import com.ftn.service.BioskopService;
import com.mysql.fabric.xmlrpc.base.Array;

@Transactional
@Service
public class JpaBioskopService implements BioskopService{
	
	@Autowired
	private BioskopRepository bioskopRepository;

	@Override
	public List<Bioskop> nadjiSveBioskope() {
		return bioskopRepository.findAll();
	}
	
	@Override
	public String kreirajBioskop(Bioskop bioskop) {
		System.out.println("Kreiranje bioskopa - servic JPA");
		bioskopRepository.save(bioskop);
		System.out.println("Zavrsio JPA...");
		return "Uspiooo...";
	}

	

}
