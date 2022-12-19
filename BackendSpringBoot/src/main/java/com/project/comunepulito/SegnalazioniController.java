package com.project.comunepulito;

//Import attualmente inutilizzati
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLIntegrityConstraintViolationException;
//import java.sql.Statement;
//import java.time.LocalDateTime;


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
public class SegnalazioniController {

	@Autowired
	private SegnalazioneRepository segnalazioneRepository;
	
	@PostMapping("/segnalazioni")
	public void SegnalazioneInsert (@RequestBody SegnalazioneBody segnalazioneBody) {		
		try{	
			Segnalazione s = new Segnalazione();
			s.setDescrizione(segnalazioneBody.getDescrizione());
			s.setFoto(segnalazioneBody.getFoto());
			s.setTipo_rifiuto(segnalazioneBody.getTipo_rifiuto());
			s.setPosizione(null); 
			s.setDataora(LocalDateTime.now());
			segnalazioneRepository.save(s);				
		}catch (Exception e) {
			System.out.println("Errore nella creazione della segnalazione.");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}		
		
			Segnalazione segnalazione= segnalazioneRepository.findById_Utente(Segnalazione.getUtente());
			System.out.println(segnalazione.getId_segnalazione());
			
	}
	
}

