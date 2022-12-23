package com.project.comunepulito;

import java.awt.Point;
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
	private SegnalazioneRepository segnalazioneRepository;
	
	@PostMapping("/segnalazione")
	public void SegnalazioneInsert (@RequestBody SegnalazioneBody segnalazioneBody) {		
		try{	
			Segnalazione s = new Segnalazione();
			s.setFoto(segnalazioneBody.getFoto());
			s.setDescrizione(segnalazioneBody.getDescrizione());
			s.setTipo_rifiuto(segnalazioneBody.getTipo_rifiuto().toString());
			s.setPosizione(new Point(segnalazioneBody.getPosizione())); 
			s.setDataora(LocalDateTime.now());
			segnalazioneRepository.save(s);				
		}catch (Exception e) {
			System.out.println("Errore nella creazione della segnalazione.");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}		
		
			/*Segnalazione segnalazione= segnalazioneRepository.findById_Utente(Segnalazione.getUtente());
			System.out.println(segnalazione.getId_segnalazione());*/ 
		//questo comando va nel controller che prede le segnalazioni dal database
			
	}
}

