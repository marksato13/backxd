package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Semestre;
import com.example.demo.repository.SemestreRepository;
import com.example.demo.service.SemestreService;

@Service

public class SemestreServiceImpl implements SemestreService<Semestre>{
	
	@Autowired
	private SemestreRepository semestreRepository;

	@Override
	public Semestre create(Semestre t) {
		// TODO Auto-generated method stub
		return semestreRepository.save(t);
	}

	@Override
	public Semestre update(Semestre t) {
		// TODO Auto-generated method stub
		return semestreRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		semestreRepository.deleteById(id);
	}

	@Override
	public Optional<Semestre> read(int id) {
		// TODO Auto-generated method stub
		return semestreRepository.findById(id);
	}

	@Override
	public List<Semestre> readAll() {
		// TODO Auto-generated method stub
		return semestreRepository.findAll();
	}

}