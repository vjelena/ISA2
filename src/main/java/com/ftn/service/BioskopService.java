package com.ftn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ftn.model.Bioskop;
import com.ftn.repository.BioskopRepository;

@Service
public interface BioskopService {
	 @JsonBackReference(value="candidate-profiles")
	public List<Bioskop> nadjiSveBioskope();
	 @JsonBackReference(value="candidate-231321")
	public String kreirajBioskop(Bioskop bioskop);

}
