package com.project.comunepulito;

import org.springframework.data.repository.CrudRepository;

public interface ClusterRepository extends CrudRepository<Cluster,Integer>{

	Cluster findByEsempio(String Esempio);

}
