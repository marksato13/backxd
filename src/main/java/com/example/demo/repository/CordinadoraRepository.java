package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cordinadora;
@Repository
public interface CordinadoraRepository extends JpaRepository<Cordinadora, Integer>{

}