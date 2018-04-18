package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Ponuda;

@Repository
public interface PonudaRepozitorijum extends JpaRepository<Ponuda, Long>{

}
