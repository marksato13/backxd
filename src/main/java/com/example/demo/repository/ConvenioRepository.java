package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Convenio;
@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Integer>{

}