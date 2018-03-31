package com.ftn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findByEmailIgnoreCaseContaining(String email);
	List<Korisnik> findByImeIgnoreCaseContainingAndPrezimeIgnoreCaseContaining(String ime, String prezime);
	//public Integer setActivated(Boolean aktiviranNalog, String email);
}
