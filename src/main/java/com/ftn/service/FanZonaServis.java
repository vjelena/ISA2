package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.model.FanZona;

@Service
public interface FanZonaServis {

	FanZona findOne(Long id);

	List<FanZona> findAll();
	
	FanZona save(FanZona fanZona);
	
	List<FanZona> save(List<FanZona> fanZone);
	
	FanZona delete(Long id);
	
	void delete(List<Long> ids);
}
