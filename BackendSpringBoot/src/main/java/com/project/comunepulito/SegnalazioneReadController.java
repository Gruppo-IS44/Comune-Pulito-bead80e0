package com.project.comunepulito;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Optional;  


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class SegnalazioneReadController {
	@Autowired
	private SegnalazioneRepository reportRepository;
	
	@PostMapping("/mappa")
	public void SegnalazioneRead (@RequestBody SegnalazioneIdBody segnalazioneIdBody){
		System.out.println("errore1");
	try{
		

		Optional<Segnalazione> segnalazione= reportRepository.findById(segnalazioneIdBody.getId_utente());
		System.out.println(segnalazione);

		
	}catch (Exception e) {
		System.out.println("Errore nella lettura della segnalazione.");
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}	
	System.out.println("SI GODE");
	}
}