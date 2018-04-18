package com.ftn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Korisnik;
import com.ftn.model.PodaciORezervaciji;

@Repository
public interface PodaciORezervacijiRepository extends JpaRepository<PodaciORezervaciji, Long> {

	List<Korisnik> findByNazivSelektovanogBioskopaAndNazivSelektovaneProjekcijeAndNazivSelektovanogTerminaAndNazivSelektovaneSaleAndNazivSelektovanogPrijatelja(String nazivSelektovanogBioskopa, String nazivSelektovaneProjekcije, String nazivSelektovanogTermina, String nazivSelektovaneSale, String nazivSelektovanogPrijatelja);
	
}
