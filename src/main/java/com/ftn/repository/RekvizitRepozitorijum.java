package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Rekvizit;

@Repository
public interface RekvizitRepozitorijum extends JpaRepository<Rekvizit, Long>{

}
