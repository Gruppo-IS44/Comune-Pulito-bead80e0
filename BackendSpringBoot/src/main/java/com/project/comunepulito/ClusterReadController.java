package com.project.comunepulito;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ClusterReadController {
	@Autowired
	private ClusterRepository clusterRepository;
	
	@PostMapping("/mappaGestore")
	public List<Cluster> ClusterRead (@RequestBody ClusterIdBody clusterIdBody){
	try{
		List<Cluster> cluster= new ArrayList<Cluster>();
		System.out.println(clusterIdBody.getId_gestore());
		for(Cluster c: clusterRepository.findAll())
		{
			if(c.getId_gestore().equals(clusterIdBody.getId_gestore())) {
				cluster.add(c);
			}
		}
		System.out.println(cluster);
		System.out.println("Operazione completata con successo.");
		return cluster;
	}catch (Exception e) {
		System.out.println("Errore nella lettura del Cluster.");
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}
	}
}
	


