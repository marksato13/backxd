package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cordinadora;
import com.example.demo.repository.CordinadoraRepository;
import com.example.demo.service.CordinadoraService;

@Service
public class CordinadoraServiceImpl implements CordinadoraService<Cordinadora>{
	
	@Autowired
	private CordinadoraRepository cordinadoraRepository;

	@Override
	public Cordinadora create(Cordinadora t) {
		// TODO Auto-generated method stub
		return cordinadoraRepository.save(t);
	}

	@Override
	public Cordinadora update(Cordinadora t) {
		// TODO Auto-generated method stub
		return cordinadoraRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cordinadoraRepository.deleteById(id);
	}

	@Override
	public Optional<Cordinadora> read(int id) {
		// TODO Auto-generated method stub
		return cordinadoraRepository.findById(id);
	}

	@Override
	public List<Cordinadora> readAll() {
		// TODO Auto-generated method stub
		return cordinadoraRepository.findAll();
	}

}