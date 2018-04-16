package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Prodavnica;

@Repository
public interface ProdavnicaRepozitorijum extends JpaRepository<Prodavnica, Long>{

}
