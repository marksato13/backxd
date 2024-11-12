package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ConvenioDto;
import com.example.demo.entity.Convenio;
import com.example.demo.entity.Tipo_Convenio;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ConvenioRepository;
import com.example.demo.repository.Tipo_ConvenioRepository;
import com.example.demo.service.ConvenioService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConvenioServiceImpl implements ConvenioService<Convenio>{
	
	@Autowired
	private ConvenioRepository convenioRepository;
	
	@Autowired
	private Tipo_ConvenioRepository tipo_ConvenioRepository;

	
	
	@Override
	public Convenio update(int id, ConvenioDto convenioDto ) {
	    Optional<Convenio> optionalConvenio = convenioRepository.findById(id);

	    if (optionalConvenio.isPresent()) {
	    	Convenio convenio = optionalConvenio.get();
	    	convenio.setNombreconvenio(convenioDto.getNombreconvenio());
	    	convenio.setTipo_Convenio(tipo_ConvenioRepository.findById(convenioDto.getTipo_Convenio()).orElse(null));
	        return convenioRepository.save(convenio);
	    } else {
	        throw new ResourceNotFoundException("convenio no encontrado con ID: " + id);
	    }
	}
	
	@Override
	public void delete(int id) {
		convenioRepository.deleteById(id);
	}
	@Override
	public Optional<Convenio> read(int id) {
	    return convenioRepository.findById(id);
	}

	@Override
	public List<Convenio> readAll() {
		return convenioRepository.findAll();
	}

	@Override
	public Convenio guardarConvenio(ConvenioDto convenioDto) {

	    Tipo_Convenio tipoConvenio = tipo_ConvenioRepository.findById(convenioDto.getTipo_Convenio())
	            .orElseThrow(() -> new EntityNotFoundException("Tipo_Convenio not found"));

	    Convenio convenio = new Convenio();
	    //atri
	    convenio.setNombreconvenio(convenioDto.getNombreconvenio());
	    //fora	
	    convenio.setTipo_Convenio(tipoConvenio);

	    return convenioRepository.save(convenio);
	}
	
	//el dto que se usa aqui es para 
	

}