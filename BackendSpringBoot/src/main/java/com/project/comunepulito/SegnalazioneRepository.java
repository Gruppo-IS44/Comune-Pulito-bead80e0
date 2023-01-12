package com.project.comunepulito;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SegnalazioneRepository extends CrudRepository<Segnalazione,Integer>{
	
	Optional<Segnalazione> findById(Integer utente);

}
