package com.project.comunepulito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ClusterController {
	
	@Autowired
	private ClusterRepository clusterRepository;
	
	@PostMapping("/cluster")
	public void ClusterCreate(@RequestBody Cluster Cluster) {		
		try{	
			Cluster c = new Cluster();
			c.setId_cluster(Cluster.getId_cluster());
			c.setRaggio(Cluster.getRaggio());
			c.setPosizione(null);
			clusterRepository.save(c);				
		}catch (Exception e) {
			System.out.println("Errore durante la creazione del cluster.");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}	
	}
}
