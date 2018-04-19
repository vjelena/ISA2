package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.ftn.model.Sediste;

@Service
public interface SedisteService {
	
	public List<Sediste> nadjiSvaSedista();
	
	
	public Sediste kreirajSediste(Sediste sediste);


	public Sediste nadjiJednoSediste(String id);
	
	
}