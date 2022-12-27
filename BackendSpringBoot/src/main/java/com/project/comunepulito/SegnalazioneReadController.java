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


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class SegnalazioneReadController {
	@Autowired
	private SegnalazioneRepository reportRepository;
	
	@PostMapping("/mappa")
	public void SegnalazioneProva (@RequestBody SegnalazioneBody segnalazioneBody){
	try{
		//FUNZIONA (CON GetDescrizione) !!
		/*Segnalazione segnalazione= reportRepository.findByDescrizione(segnalazioneBody.getDescrizione());
		System.out.println(segnalazione.getId_segnalazione());*/
		
		//NON FUNZIONA !!
		/*Segnalazione segnalazione= reportRepository.findById(segnalazioneBody.getId_utente());
		System.out.println(segnalazione.getId_segnalazione());*/

		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Gestore Inesistente.");
	}catch (Exception e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Errore Interno al Server");
		}
	
	}
}