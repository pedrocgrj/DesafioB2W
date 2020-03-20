package com.DesafioB2W.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioB2W.domain.Planeta;
import com.DesafioB2W.dto.PlanetaDTO;
import com.DesafioB2W.services.PlanetaService;

@RestController
@RequestMapping(value="/planetas")
public class PlanetaResource {
	
	@Autowired
	private PlanetaService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PlanetaDTO>> findall(){
		List<Planeta> list = service.findAll();
		List<PlanetaDTO> listdto = list.stream().map(x -> new PlanetaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<PlanetaDTO> findById(@PathVariable String id) {
		Planeta obj = service.findById(id);
		return ResponseEntity.ok().body(new PlanetaDTO(obj));
	}
}
