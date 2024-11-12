package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tipo_Convenio;
import com.example.demo.repository.Tipo_ConvenioRepository;
import com.example.demo.service.Tipo_ConvenioService;

@Service
public class Tipo_ConvenioServiceImpl implements  Tipo_ConvenioService<Tipo_Convenio>{
	
	@Autowired
	private Tipo_ConvenioRepository tipo_ConvenioRepository;

	@Override
	public Tipo_Convenio create(Tipo_Convenio t) {
		// TODO Auto-generated method stub
		return tipo_ConvenioRepository.save(t);
	}

	@Override
	public Tipo_Convenio update(Tipo_Convenio t) {
		// TODO Auto-generated method stub
		return tipo_ConvenioRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tipo_ConvenioRepository.deleteById(id);
	}

	@Override
	public Optional<Tipo_Convenio> read(int id) {
		// TODO Auto-generated method stub
		return tipo_ConvenioRepository.findById(id);
	}

	@Override
	public List<Tipo_Convenio> readAll() {
		// TODO Auto-generated method stub
		return tipo_ConvenioRepository.findAll();
	}

}