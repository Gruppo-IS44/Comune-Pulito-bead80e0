package com.project.comunepulito;

import org.springframework.data.repository.CrudRepository;

public interface OrdineRepository extends CrudRepository<Ordine,Integer>{

	Ordine findBydadefinire(String dadefinire);

}
