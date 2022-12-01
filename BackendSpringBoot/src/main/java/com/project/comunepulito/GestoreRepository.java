package com.project.comunepulito;

import org.springframework.data.repository.CrudRepository;

public interface GestoreRepository extends CrudRepository<Gestore,Integer>{
	
	Gestore findByEmail(String email);
}
