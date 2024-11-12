package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario_Opciones;
@Repository
public interface Usuario_OpcionesRepository extends JpaRepository<Usuario_Opciones, Integer>{

}