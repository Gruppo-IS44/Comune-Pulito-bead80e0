package com.project.comunepulito;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClusterRepository extends CrudRepository<Cluster, Integer> {
	
	Optional<Cluster> findById(Integer id);
	
	/*@Query(value="SELECT s.Id_cluster FROM Segnalazione s LEFT JOIN Cluster c ON s.Id_cluster=c.Id_cluster")
	List<Segnalazione> findSegnalazioneCluster();*/
}
