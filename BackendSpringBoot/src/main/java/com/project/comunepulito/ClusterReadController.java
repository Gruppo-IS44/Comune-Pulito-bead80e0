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
	public List<Response> ClusterRead (@RequestBody ClusterIdBody clusterIdBody){
	try{
//		List<Cluster> cluster= new ArrayList<Cluster>();
//		System.out.println(clusterIdBody.getId_gestore());
//		for(Cluster c: clusterRepository.findAll())
//		{
//			if(c.getId_gestore().equals(clusterIdBody.getId_gestore())) {
//				cluster.add(c);
//			}
//		}
		List<Cluster> cluster= clusterRepository.findClusterByIdGestore(clusterIdBody.getId_gestore());
		System.out.println(cluster);
		List<Response> risp=new ArrayList<Response>();
		for (Cluster c:cluster) {
			risp.add(new Response(c, clusterRepository.findSegnalazioneCluster(c.getId_cluster())));
		}
		System.out.println("Operazione completata con successo.");
		return risp;
	}catch (Exception e) {
		System.out.println("Errore nella lettura del Cluster.");
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}
	}
	
	public class Response{
		private Cluster id_cluster;
		private List<Segnalazione> segnalazioni;
		
		public Response(Cluster id_cluster, List<Segnalazione> segnalazioni) {
			this.id_cluster=id_cluster;
			this.segnalazioni=segnalazioni;
		}

		public Cluster getId_cluster() {
			return id_cluster;
		}

		public void setId_cluster(Cluster id_cluster) {
			this.id_cluster = id_cluster;
		}

		public List<Segnalazione> getSegnalazioni() {
			return segnalazioni;
		}

		public void setSegnalazioni(List<Segnalazione> segnalazioni) {
			this.segnalazioni = segnalazioni;
		}

		@Override
		public String toString() {
			return "Response [id_cluster=" + id_cluster + ", segnalazioni=" + segnalazioni + "]";
		}		
	}
}
	


