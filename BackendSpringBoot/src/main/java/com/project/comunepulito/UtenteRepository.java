package com.project.comunepulito;

import org.springframework.data.repository.CrudRepository;

public interface UtenteRepository extends CrudRepository<Utente,Integer>{

	Utente findByEmail(String email);

}
