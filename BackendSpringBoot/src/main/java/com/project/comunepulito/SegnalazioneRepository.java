package com.project.comunepulito;

import org.springframework.data.repository.CrudRepository;


public interface SegnalazioneRepository extends CrudRepository<Segnalazione,Utente>{
	
	//FUNZIONA !!
	//Segnalazione findByDescrizione(String descrizione); 
	
	//NON FUNZIONA !!
	//Segnalazione findById(Integer Id_utente);
			
}
