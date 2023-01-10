package com.project.comunepulito;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RisolviClusterController {
	@Autowired
	private SegnalazioneRepository segnalazioneRepository;
	
	@PostMapping("/testing")
	public Integer Esempio (@RequestBody RisolviClusterBody risolviclusterBody){
		
		Segnalazione s = segnalazioneRepository.findById(risolviclusterBody.getSegnalazione()).get();
		
		
		s.setId_Stato(risolviclusterBody.getId_Stato());
		System.out.println(risolviclusterBody.getId_Stato());
		segnalazioneRepository.save(s);
		
		return null;
	}
	
	

}
