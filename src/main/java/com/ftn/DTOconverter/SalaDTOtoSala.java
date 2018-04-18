package com.ftn.DTOconverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.DTO.ProjekcijaDTO;
import com.ftn.DTO.SalaDTO;
import com.ftn.model.Bioskop;
import com.ftn.model.Projekcija;
import com.ftn.model.Sala;
import com.ftn.service.BioskopService;
import com.ftn.service.impl.JpaFilmService;
import com.ftn.service.impl.JpaSalaService;
import com.ftn.service.impl.JpaTerminService;

@Component
public class SalaDTOtoSala {

	
	@Autowired
	private BioskopService bioskopService;
	
	@Autowired
	private JpaSalaService jpaSalaService ;
	
	
	public Sala convert(SalaDTO source) {
		
		if(source == null) {
			return null;
		}
		
		Bioskop bioskop = bioskopService.nadjiJedanBioskop(source.getBioskop());
		
		
		Sala sala = new Sala();
		sala.setBioskop(bioskop);
		sala.setBrojMesta(source.getBrojMesta());
		sala.setKonfiguracija(source.getKonfiguracija());
		sala.setNazivSale(source.getBrojSale());
		
		return sala;
	}
	
	
public List<Sala> convert(List<SalaDTO> source){
		
		List<Sala> sale = new ArrayList<Sala>();
		for (SalaDTO salaDTO : source) {
			sale.add(convert(salaDTO));
		}
		return sale;
	}
	
}
