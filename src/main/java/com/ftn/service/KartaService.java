package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Karta;

@Service
public interface KartaService {
	
	public List<Karta> nadjiSveKarte();
	
	
	public Karta kreirajKartu(Karta karta);


	public Karta nadjiJednuKartu(String id);
}