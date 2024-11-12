package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Semestre;
import com.example.demo.serviceImpl.SemestreServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_SEMESTRE;

@RestController
@RequestMapping(API_SEMESTRE)
@CrossOrigin({"*"})

public class SemestreController {
	@Autowired
	private SemestreServiceImpl semestreServiceImpl;
	
	
	@GetMapping("/ListSeme")
	public ResponseEntity<List<Semestre>> listar() {
		try {
		      List<Semestre> alq = semestreServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarSeme/{id}")
	public ResponseEntity<Semestre> getSemestreById(@PathVariable("id") int id){
		Optional<Semestre> carData = semestreServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Semestre>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertSeme")
    public ResponseEntity<Semestre> crear(@Valid @RequestBody Semestre semestre){
        try {
        	Semestre _alq = semestreServiceImpl.create(semestre);
            return new ResponseEntity<Semestre>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteSeme/{id}")
	public ResponseEntity<Semestre> delete(@PathVariable("id") int id){
		try {
			semestreServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidSeme/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Semestre semestre){
		Optional<Semestre> carData = semestreServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Semestre dbsemestre = carData.get();
	    	  dbsemestre.setNombresemeste(semestre.getNombresemeste());
	 
	        
	        return new ResponseEntity<Semestre>(semestreServiceImpl.update(dbsemestre), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}