package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cordinadora;
import com.example.demo.serviceImpl.CordinadoraServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_CORDINADORA;

@RestController
@RequestMapping(API_CORDINADORA)
@CrossOrigin({"*"})

public class CordinadoraController {
	@Autowired
	private CordinadoraServiceImpl cordinadoraServiceImpl;
	
	
	@GetMapping("/ListDora")
	public ResponseEntity<List<Cordinadora>> listar() {
		try {
		      List<Cordinadora> alq = cordinadoraServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarDora/{id}")
	public ResponseEntity<Cordinadora> getEquipoById(@PathVariable("id") int id){
		Optional<Cordinadora> carData = cordinadoraServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Cordinadora>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertDora")
    public ResponseEntity<Cordinadora> crear(@Valid @RequestBody Cordinadora cordinadora){
        try {
        	Cordinadora _alq = cordinadoraServiceImpl.create(cordinadora);
            return new ResponseEntity<Cordinadora>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteDora/{id}")
	public ResponseEntity<Cordinadora> delete(@PathVariable("id") int id){
		try {
			cordinadoraServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidDora/{id}")
	public ResponseEntity<?> updateCarrera(@PathVariable("id") int id, @Valid @RequestBody Cordinadora cordinadora){
		Optional<Cordinadora> carData = cordinadoraServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Cordinadora dbcordinadora = carData.get();
	    	  dbcordinadora.setCodigocordinadora(cordinadora.getCodigocordinadora());
	 
	        
	        return new ResponseEntity<Cordinadora>(cordinadoraServiceImpl.update(dbcordinadora), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}