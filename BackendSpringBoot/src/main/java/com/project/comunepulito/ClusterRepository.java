package com.project.comunepulito;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClusterRepository extends CrudRepository<Cluster, Integer> {
	Optional<Cluster> findById(Integer id);
}
