package com.project.comunepulito;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UtenteRepository extends CrudRepository<Utente,Integer>{

	Optional<Utente> findByEmail(String email);

}
