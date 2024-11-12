package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Alumno;
import com.example.demo.serviceImpl.AlumnoServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_ALUMNO;

@RestController
@RequestMapping(API_ALUMNO)
@CrossOrigin({"*"})

public class AlumnoController {
	@Autowired
	private AlumnoServiceImpl alumnoServiceImpl;
	
	
	@GetMapping("/ListAlum")
	public ResponseEntity<List<Alumno>> listar() {
		try {
		      List<Alumno> alq = alumnoServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarAlum/{id}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable("id") int id){
		Optional<Alumno> carData = alumnoServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Alumno>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertAlum")
    public ResponseEntity<Alumno> crear(@Valid @RequestBody Alumno alumno){
        try {
        	Alumno _alq = alumnoServiceImpl.create(alumno);
            return new ResponseEntity<Alumno>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteAlum/{id}")
	public ResponseEntity<Alumno> delete(@PathVariable("id") int id){
		try {
			alumnoServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidAlum/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Alumno alumno){
		Optional<Alumno> carData = alumnoServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Alumno dbalumno = carData.get();
	    	  
	    	  dbalumno.setCodigo_alumno(alumno.getCodigo_alumno());
	 
	        
	        return new ResponseEntity<Alumno>(alumnoServiceImpl.update(dbalumno), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}