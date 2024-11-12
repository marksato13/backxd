package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ConvenioDto;
import com.example.demo.entity.Convenio;
import com.example.demo.serviceImpl.ConvenioServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.commons.GlobalConstans.API_CONVENIO;

@RestController
@RequestMapping(API_CONVENIO)
@CrossOrigin({"*"})

public class ConvenioController {
	@Autowired
	private ConvenioServiceImpl convenioServiceImpl;


	
	@GetMapping("/ListConv")
	public ResponseEntity<List<Convenio>> listar() {
		try {
		      List<Convenio> alq = convenioServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("BuscarConv/{id}")
	public ResponseEntity<Convenio> getConvenioById(@PathVariable("id") int id){
		Optional<Convenio> carData = convenioServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Convenio>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	//anotaciones 

	@PostMapping("/Insertconv")
	public ResponseEntity<Convenio> guardarConvenio(@Valid @RequestBody ConvenioDto convenioDto) {
	    try {
	        Convenio _alq = convenioServiceImpl.guardarConvenio(convenioDto);
	        return new ResponseEntity<Convenio>(_alq, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	

	@DeleteMapping("DeleteConv/{id}")
	public ResponseEntity<Convenio> delete(@PathVariable("id") int id){
		try {
			convenioServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	

	 @PutMapping("/EdidConv/{id}")
	    public ResponseEntity<Convenio> updateLibro(@PathVariable("id") int id, @Valid @RequestBody ConvenioDto convenioDto) {
	        try {
	        	Convenio updatedConvenio = convenioServiceImpl.update(id, convenioDto);
	            return new ResponseEntity<>(updatedConvenio, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	}