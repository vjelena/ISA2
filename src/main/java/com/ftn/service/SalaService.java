package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Film;
import com.ftn.model.Sala;

@Service
public interface SalaService {
	
	public List<Sala> nadjiSveSale();
	
	public Sala azurirajKonfiguraciju(Sala sala);

	public Sala kreirajSalu(Sala sala);

}
