package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Opciones;
@Repository
public interface OpcionesRepository extends JpaRepository<Opciones, Integer>{

}