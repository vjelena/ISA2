package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Skala;

@Repository
public interface SkalaRepository extends JpaRepository<Skala, Long> {

}
