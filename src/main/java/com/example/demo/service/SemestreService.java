package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface SemestreService  <T>{
	
	T create(T t);
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();

}	