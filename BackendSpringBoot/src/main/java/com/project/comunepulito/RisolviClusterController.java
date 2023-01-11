package com.project.comunepulito;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RisolviClusterController {
	@Autowired
	private SegnalazioneRepository segnalazioneRepository;
	@Autowired
	private ClusterRepository clusterRepository;
	@Autowired
	private UtenteRepository utenteRepository;
	
	@PostMapping("/convalida")
	public Integer Esempio (@RequestBody RisolviClusterBody risolviclusterBody){
		System.out.println(risolviclusterBody);
		for(Segnalazione s:risolviclusterBody.getSegnalazioni()) {
			segnalazioneRepository.save(s);
			Utente u=utenteRepository.findById(s.getId_utente()).get();
			if(s.getId_Stato()==2) {//Segnalazione Valida
				System.out.println(s.getId_Tipo());
				switch(s.getId_Tipo()) {
					case 1:
						u.setBilancio(u.getBilancio()+10);// 1 RIFIUTO PICCOLO
						break;
					case 2:
						u.setBilancio(u.getBilancio()+20);// 2 RIFIUTO GRANDE
						break;
					case 3:
						u.setBilancio(u.getBilancio()+30);// 3 RIFIUTO ALTRO
						break;
				}
				continue;
			}//Segnalazione non valida=>Warn Utente
			u.setWarn(u.getWarn()+1);
			if(u.getWarn()==3)//Al terzo warn, l'utente viene bannato.
				u.setBan(true);
			utenteRepository.save(u);
		}
		clusterRepository.save(risolviclusterBody.getCluster());
		return null;
	}
}
