package com.ftn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ftn.model.Bioskop;
import com.ftn.model.Pozoriste;

@Repository
public interface PozoristeRepository extends JpaRepository<Pozoriste, Long> {

	Pozoriste findById(Long id);
	Pozoriste findByNaziv(String naziv);
	
	//za pretragu bioskopa
	List<Pozoriste> findByNazivIgnoreCaseContaining(String naziv);
}
