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
public class SegnalazioneReadController {
	@Autowired
	private SegnalazioneRepository segnalazioneRepository;
	
	@PostMapping("/mappa")
	public List<Segnalazione> SegnalazioneRead (@RequestBody SegnalazioneIdBody segnalazioneIdBody){//DEPRECATED
	try{
		List<Segnalazione> segnalazioni= new ArrayList<Segnalazione>();
		System.out.println(segnalazioneIdBody.getId_utente());
		for(Segnalazione s:segnalazioneRepository.findAll())
		{
			if(s.getId_utente().equals(segnalazioneIdBody.getId_utente())) {
				segnalazioni.add(s);
			}
		}
		System.out.println(segnalazioni);
		System.out.println("Operazione completata con successo.");
		return segnalazioni;
	}catch (Exception e) {
		System.out.println("Errore nella lettura della segnalazione.");
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
	}
	}
}