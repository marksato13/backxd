package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tipo_Convenio;
import com.example.demo.serviceImpl.Tipo_ConvenioServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_TIPO_CONVENIO;

@RestController
@RequestMapping(API_TIPO_CONVENIO)
@CrossOrigin({"*"})

public class Tipo_ConvenioController {
	@Autowired
	private Tipo_ConvenioServiceImpl tipo_ConvenioServiceImpl;
	
	
	@GetMapping("/ListTipoC")
	public ResponseEntity<List<Tipo_Convenio>> listar() {
		try {
		      List<Tipo_Convenio> alq = tipo_ConvenioServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarTipoC/{id}")
	public ResponseEntity<Tipo_Convenio> getTipo_ConvenioById(@PathVariable("id") int id){
		Optional<Tipo_Convenio> carData = tipo_ConvenioServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Tipo_Convenio>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertTipoC")
    public ResponseEntity<Tipo_Convenio> crear(@Valid @RequestBody Tipo_Convenio tipo_Convenio){
        try {
        	Tipo_Convenio _alq = tipo_ConvenioServiceImpl.create(tipo_Convenio);
            return new ResponseEntity<Tipo_Convenio>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteTipoC/{id}")
	public ResponseEntity<Tipo_Convenio> delete(@PathVariable("id") int id){
		try {
			tipo_ConvenioServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidTipoC/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Tipo_Convenio tipo_Convenio){
		Optional<Tipo_Convenio> carData = tipo_ConvenioServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Tipo_Convenio dbtipo_Convenio = carData.get();
	    	  dbtipo_Convenio.setNombretipoconvenio(tipo_Convenio.getNombretipoconvenio());
	 
	        
	        return new ResponseEntity<Tipo_Convenio>(tipo_ConvenioServiceImpl.update(dbtipo_Convenio), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}