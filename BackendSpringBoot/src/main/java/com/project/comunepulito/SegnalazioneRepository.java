package com.project.comunepulito;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SegnalazioneRepository extends CrudRepository<Segnalazione,Integer>{
	
	Optional<Segnalazione> findById(Integer utente);

	@Query(value="UPDATE Segnalazione SET Id_Stato=?2 WHERE Id_segnalazione=?1")
	void UpdateByIdSegnalazione(Integer idSegnalazione, Integer idStato);
	
	/*@Query(value="UPDATE Utente SET Warn WHERE Id_utente=?1")
	 * void UpdateWarnUtente(Integer idUtente);
	*/
}
