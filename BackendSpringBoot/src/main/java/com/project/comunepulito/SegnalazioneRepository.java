package com.project.comunepulito;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface SegnalazioneRepository extends CrudRepository<Segnalazione,Integer>{
	
	Optional<Segnalazione> findById(Integer utente);

			
}
