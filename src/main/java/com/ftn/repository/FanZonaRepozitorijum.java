package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.FanZona;

@Repository
public interface FanZonaRepozitorijum extends JpaRepository<FanZona, Long>{

}
