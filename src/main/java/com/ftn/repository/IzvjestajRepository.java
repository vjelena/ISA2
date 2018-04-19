package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.model.Film;
import com.ftn.model.IzvestajOPoslovanju;

public interface IzvjestajRepository  extends JpaRepository<IzvestajOPoslovanju, Long>{

}
