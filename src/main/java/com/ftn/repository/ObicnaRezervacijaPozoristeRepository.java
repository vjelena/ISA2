package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.ObicnaRezervacijaPozoriste;

@Repository
public interface ObicnaRezervacijaPozoristeRepository extends JpaRepository<ObicnaRezervacijaPozoriste, Long> {

	ObicnaRezervacijaPozoriste findById(Long id);
	
}
