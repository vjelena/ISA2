package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.Sala;
import com.ftn.model.Termin;

@Service
public interface TerminService {
	
	public List<Termin> nadjiSveTermine();

}
