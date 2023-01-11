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
	
	@PostMapping("/convalida")
	public Integer Esempio (@RequestBody RisolviClusterBody risolviclusterBody){
		
//		Segnalazione s = segnalazioneRepository.findById(risolviclusterBody.getSegnalazione()).get();
//		
//		
//		s.setId_Stato(risolviclusterBody.getId_Stato());
//		System.out.println(risolviclusterBody.getId_Stato());
//		segnalazioneRepository.save(s);
		System.out.println(risolviclusterBody);
		
/*		Segnalazione s = segnalazioneRepository.findById(risolviclusterBody.getSegnalazione()).get();
		
		Utente u = utenteRepository.findById(risolviclusterBody.getId_Utente()).get();
		
		s.setId_Stato(risolviclusterBody.getId_Stato());

		if (s.getId_Stato() == 3) {		// 3 è la segnalazione NON VALIDA
			
			System.out.println("Segnalazione NON-VALIDA");
			u.setWarn(u.getWarn()+1);
			
			if(u.getWarn() == 3) {
				u.setBan(true);
			}

		}
		
		System.out.println(risolviclusterBody.getId_Stato());
		segnalazioneRepository.save(s);
		
		switch(s.getId_Tipo()) {
			case 1:
				u.setBilancio(u.getBilancio()+10);		// 1 RIFIUTO PICCOLO
				break;
			case 2:
				u.setBilancio(u.getBilancio()+20);		// 2 RIFIUTO GRANDE
				break;
			case 3:
				u.setBilancio(u.getBilancio()+30);		// 3 RIFIUTO ALTRO
				break;			

		}
				System.out.println("Bilancio utente aumentato: " + u.getBilancio());	*/

		return null;
	}
	
	

}
