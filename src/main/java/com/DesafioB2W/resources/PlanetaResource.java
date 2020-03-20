package com.DesafioB2W.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioB2W.domain.Planeta;

@RestController
@RequestMapping(value="/planetas")
public class PlanetaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Planeta>> findall(){
		Planeta teste = new Planeta("1", "teste", "quente", "árido");
		Planeta teste2 = new Planeta("2", "teste", "quente", "árido");
		List<Planeta> list = new ArrayList<>();
		list.addAll(Arrays.asList(teste,teste2));
		return ResponseEntity.ok().body(list);
	}
}
