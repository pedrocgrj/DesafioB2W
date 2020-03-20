package com.DesafioB2W.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DesafioB2W.domain.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {

	@Transactional(readOnly=true)
	Planeta findByNome(String nome);
}
