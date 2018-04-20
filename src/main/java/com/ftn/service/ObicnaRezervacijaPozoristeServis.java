package com.ftn.service;

import java.util.List;

import com.ftn.model.ObicnaRezervacijaPozoriste;

public interface ObicnaRezervacijaPozoristeServis {

	List<ObicnaRezervacijaPozoriste> findAll();
	
	ObicnaRezervacijaPozoriste save(ObicnaRezervacijaPozoriste obicnaRezervacijaPozoriste);
	
}
