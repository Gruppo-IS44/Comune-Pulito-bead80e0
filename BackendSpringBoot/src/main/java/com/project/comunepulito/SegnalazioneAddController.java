package com.project.comunepulito;


import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class SegnalazioneAddController {
	@Autowired
	private SegnalazioneRepository reportRepository;
	@Autowired
	private ClusterRepository clusterRepository;
	@Autowired
	private GestoreRepository Gestori;	
	
	@PostMapping("/segnalazione")
	public void SegnalazioneInsert (@RequestBody SegnalazioneBody segnalazioneBody) {		
		try{
			Segnalazione s = new Segnalazione();
			s.setFoto(segnalazioneBody.getFoto());
			//s.setDescrizione(segnalazioneBody.getDescrizione()); //Assente su DB
			s.setId_Tipo(segnalazioneBody.getTipo_rifiuto());
			s.setId_utente(segnalazioneBody.getId_utente());
			s.setId_cluster(scegliCluster(segnalazioneBody.getLatitudine(), segnalazioneBody.getLongitudine()));
			s.setId_Stato(1);
			s.setLatitudine(segnalazioneBody.getLatitudine());
			s.setLongitudine(segnalazioneBody.getLongitudine());
			s.setDataora(LocalDateTime.now());
			reportRepository.save(s);
		}catch (Exception e) {
			System.out.println("Errore nella creazione della segnalazione.");
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}
		System.out.println("Segnalazione creata con successo.");
	}

	private Integer scegliCluster(float latitudine, float longitudine) {
		//Reminder: distanza (A,B) = R * arccos(sin(latA) * sin(latB) + cos(latA) * cos(latB) * cos(lonA-lonB)), R = 6372,795477598 Km, Rbase cluster=0.1km
		final float R=6372.795477598f;
		for(Cluster c:clusterRepository.findAll()) {
			double dist=R*Math.acos(Math.sin(c.getLatitudine())*Math.sin(latitudine) + Math.cos(c.getLatitudine())*Math.cos(latitudine)*Math.cos(c.getLongitudine()-longitudine));
			if(dist<c.getRaggio())
				return c.getId_cluster();
		}
		Cluster c=new Cluster();
		c.setId_stato(1);
		c.setLatitudine(latitudine);
		c.setLongitudine(longitudine);
		c.setRaggio(0.2f);
		c.setId_gestore(Gestori.findGestoreLibero().get(0));
		return clusterRepository.save(c).getId_cluster();
	}
}

