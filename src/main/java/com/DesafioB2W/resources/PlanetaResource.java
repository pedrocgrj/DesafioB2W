package com.DesafioB2W.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody PlanetaDTO objDto) {
		Planeta obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody PlanetaDTO objDto, @PathVariable String id) {
		Planeta obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/nome/{nome}", method=RequestMethod.GET)
	public ResponseEntity<Planeta> find(@PathVariable String nome) {
		Planeta obj = service.findByNome(nome);
		return ResponseEntity.ok().body(obj);
	}
}
