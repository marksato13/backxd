package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Escuela_ProfecionalDto;
import com.example.demo.entity.Escuela_Profecional;
import com.example.demo.entity.Facultad;
import com.example.demo.repository.Escuela_ProfecionalRepository;
import com.example.demo.repository.FacultadRepository;
import com.example.demo.service.Escuela_ProfecionalService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Escuela_ProfecionalServiceImpl implements Escuela_ProfecionalService<Escuela_Profecional>{
	
	@Autowired
	private Escuela_ProfecionalRepository escuela_ProfecionalRepository;
	
	@Autowired
	private FacultadRepository facultadRepository;

	@Override
	public Escuela_Profecional update(Escuela_Profecional t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Escuela_Profecional> read(int id) {
		return Optional.empty();
	}
	
	@Override
	public List<Escuela_Profecional> readAll() {
		return escuela_ProfecionalRepository.findAll();
	}

	@Override
	public Escuela_Profecional guardarEscuela_Profecional(Escuela_ProfecionalDto escuela_ProfecionalDto) {

	    Facultad facultad = facultadRepository.findById(escuela_ProfecionalDto.getFacultad())
	            .orElseThrow(() -> new EntityNotFoundException("Facultad not found"));

	    Escuela_Profecional escuela_Profecional = new Escuela_Profecional();
	    escuela_Profecional.setNombreea(escuela_ProfecionalDto.getNombreea());
	    escuela_Profecional.setFacultad(facultad);

	    return escuela_ProfecionalRepository.save(escuela_Profecional);
	}
}
	
	

