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
	private SegnalazioneRepository reportRepository;
	
	@PostMapping("/testing")
	public void Esempio (@RequestBody RisolviClusterBody risolviclusterBody){
		
		reportRepository.UpdateByIdSegnalazione(risolviclusterBody.getSegnalazione(), risolviclusterBody.getId_Stato());
	}
	
	

}
