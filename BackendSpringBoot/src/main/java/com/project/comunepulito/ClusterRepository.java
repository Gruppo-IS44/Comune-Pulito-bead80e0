package com.project.comunepulito;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClusterRepository extends CrudRepository<Cluster, Integer> {
	
	Optional<Cluster> findById(Integer id);
	
	@Query(value="SELECT c FROM  Cluster c WHERE c.Id_gestore=?1")
	List<Cluster> findClusterByIdGestore(Integer idGestore);	//Recupera gli id dei cluster relativi al gestore indicato
	
	@Query(value="SELECT s FROM Segnalazione s LEFT JOIN Cluster c ON s.Id_cluster=c.Id_cluster WHERE c.Id_cluster=?1")
	List<Segnalazione> findSegnalazioneCluster(Integer idCluster);
}
