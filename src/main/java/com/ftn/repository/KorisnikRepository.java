package com.ftn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftn.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	Korisnik findByEmailIgnoreCaseContaining(String email);
	List<Korisnik> findByImeIgnoreCaseContainingAndPrezimeIgnoreCaseContaining(String ime, String prezime);
	
	/* @Transactional
	 @Modifying
	 @Query("update Korisnik k set k.aktiviranNalog = ?1 where k.email = ?2")
	void setActivated(Boolean aktiviranNalog, String email);*/
}
