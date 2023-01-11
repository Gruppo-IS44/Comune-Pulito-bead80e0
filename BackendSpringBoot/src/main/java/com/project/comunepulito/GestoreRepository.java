package com.project.comunepulito;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GestoreRepository extends CrudRepository<Gestore,Integer>{
	
	Optional<Gestore> findByEmail(String email);
	
	@Query(value="SELECT g.Id_gestore FROM Gestore g LEFT JOIN Cluster c ON g.Id_gestore=c.Id_gestore GROUP BY g.Id_gestore ORDER BY COUNT(*)")
	List<Integer> findGestoreLibero();
}
