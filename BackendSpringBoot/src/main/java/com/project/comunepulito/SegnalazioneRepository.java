package com.project.comunepulito;


import org.springframework.data.repository.CrudRepository;


public interface SegnalazioneRepository extends CrudRepository<Segnalazione,Integer>{
	
	Segnalazione findById_Utente(Utente Id_utente);
			
}