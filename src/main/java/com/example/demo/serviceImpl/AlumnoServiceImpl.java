package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService<Alumno>{
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public Alumno create(Alumno t) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(t);
	}

	@Override
	public Alumno update(Alumno t) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

	@Override
	public Optional<Alumno> read(int id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id);
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

}