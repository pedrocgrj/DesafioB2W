package com.DesafioB2W.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DesafioB2W.domain.Planeta;
import com.DesafioB2W.dto.PlanetaDTO;
import com.DesafioB2W.repository.PlanetaRepository;
import com.DesafioB2W.services.exception.ObjectNotFoundException;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repo;
	
	public List<Planeta> findAll(){
		return repo.findAll();
	}
	
	public Planeta findById(String id) {
		Optional<Planeta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Planeta não encontrado"));
	}
	
	public Planeta insert(Planeta obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
	
	public Planeta fromDTO(PlanetaDTO objDto) {
		return new Planeta(objDto.getId(), objDto.getNome(),objDto.getClima(), objDto.getTerreno());
	}
	
}
