package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tipo_Convenio;
@Repository
public interface Tipo_ConvenioRepository extends JpaRepository<Tipo_Convenio, Integer>{

}