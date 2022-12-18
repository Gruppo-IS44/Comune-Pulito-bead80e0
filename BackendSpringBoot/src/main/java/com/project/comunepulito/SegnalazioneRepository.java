package com.project.comunepulito;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SegnalazioneRepository extends CrudRepository<Segnalazione,Integer>{
	
	@Query("SELECT * FROM segnalazione WHERE Id_Utente = :Id_utente ")
	Segnalazione findById_Utente(
			@Param("Id_utente") String Utente);
			
}