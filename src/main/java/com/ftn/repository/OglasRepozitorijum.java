package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Oglas;

@Repository
public interface OglasRepozitorijum extends JpaRepository<Oglas, Long>{

}
