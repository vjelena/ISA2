package com.ftn.DTOconverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.DTO.FilmDTO;
import com.ftn.DTO.SalaDTO;
import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.model.Glumac;
import com.ftn.model.Sala;
import com.ftn.service.BioskopService;
import com.ftn.service.impl.JpaFilmService;
import com.ftn.service.impl.JpaGlumacService;
import com.ftn.service.impl.JpaSalaService;

@Component
public class FilmDTOtoFilm {


	@Autowired
	private JpaFilmService jpaFilmService ;
	
	@Autowired
	private JpaGlumacService jpaGlumacService ;
	
	
	public Film convert(FilmDTO source) {
		
		if(source == null) {
			return null;
		}
		
		
		Film film = new Film();
		film.setNaziv(source.getNaziv());
		film.setOpis(source.getOpis());
		film.setReditelj(source.getReditelj());
		film.setZanr(source.getZanr());
		film.setTrajanje(source.getTrajanje());
		film.setOcena(source.getOcena());
		film.setSlika(source.getSlika());
		
		Long[] listaGlumaca = source.getListaGlumaca();
		
		for(int i = 0; i<listaGlumaca.length; i++) {
			System.out.println("=======Trenutni id: " + Long.toString(listaGlumaca[i]));
			String idTrenutnogGlumca = Long.toString(listaGlumaca[i]);
			
			Glumac glumac = jpaGlumacService.nadjiJednogGlumca(idTrenutnogGlumca);
			System.out.println("=======Trenutni glumac: " + glumac);
			film.getGlumci().add(glumac);
		}
		
		return film;
	}
	
	
public List<Film> convert(List<FilmDTO> source){
		
		List<Film> film = new ArrayList<Film>();
		for (FilmDTO filmDTO : source) {
			film.add(convert(filmDTO));
		}
		return film;
	}
	
}
