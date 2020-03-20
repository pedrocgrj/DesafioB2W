package com.DesafioB2W.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.DesafioB2W.domain.Planeta;
import com.DesafioB2W.repository.PlanetaRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		planetaRepository.deleteAll();
		
		Planeta yavin = new Planeta(null, "Yavin IV", "temperate, tropical", "jungle, rainforests");
		
		planetaRepository.saveAll(Arrays.asList(yavin));
	}

}
