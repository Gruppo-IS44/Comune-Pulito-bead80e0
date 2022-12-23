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
	
	@PostMapping("/segnalazione")
	public void SegnalazioneInsert (@RequestBody SegnalazioneBody segnalazioneBody) {		
		try{	
			Segnalazione s = new Segnalazione();
			s.setFoto(segnalazioneBody.getFoto());
			s.setDescrizione(segnalazioneBody.getDescrizione());
			s.setTipo_rifiuto(segnalazioneBody.getTipo_rifiuto().toString());
			s.setLatitudine(null);
			s.setLongitudine(null);
			s.setDataora(LocalDateTime.now());
			reportRepository.save(s);				
		}catch (Exception e) {
			System.out.println("Errore nella creazione della segnalazione.");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Errore generico.");
		}	
	}
}

