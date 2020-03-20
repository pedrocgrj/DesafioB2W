package com.DesafioB2W.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DesafioB2W.domain.Planeta;
import com.DesafioB2W.repository.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repo;
	
	public List<Planeta> findAll(){
		return repo.findAll();
	}
}
