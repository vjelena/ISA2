package com.ftn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ftn.model.Bioskop;

@Repository
public interface BioskopRepository extends JpaRepository<Bioskop, Long> {

	//za pretragu bioskopa
	List<Bioskop> findByNazivIgnoreCaseContaining(String naziv);
}
