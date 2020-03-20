package com.DesafioB2W.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioB2W.domain.Planeta;
import com.DesafioB2W.services.PlanetaService;

@RestController
@RequestMapping(value="/planetas")
public class PlanetaResource {
	
	@Autowired
	private PlanetaService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Planeta>> findall(){
		List<Planeta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
