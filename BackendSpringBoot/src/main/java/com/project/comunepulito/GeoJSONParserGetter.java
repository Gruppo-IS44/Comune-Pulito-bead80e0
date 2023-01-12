package com.project.comunepulito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class GeoJSONParserGetter {
	@Autowired
	private SegnalazioneRepository Segnalazioni;	
	
	@GetMapping("/geojson")
	public String GeoJson() {
		System.out.println("Creazione GeoJSON in CORSo...");
		String risposta="{\"type\":\"FeatureCollection\", \"features\": [";
		long num=Segnalazioni.count();
		long i=0;
		for(Segnalazione s:Segnalazioni.findAll()) {
			i++;
			risposta = risposta.concat("{\"type\": \"Feature\", \"geometry\": {\"type\": \"Point\", \"coordinates\": ["+s.getLongitudine()+", "+s.getLatitudine()+"]}, \"id\": "+s.getId_segnalazione()+", \"properties\": {\"descrizione\": \""+s.getDescrizione()+"\", \"foto\": \""+s.getFoto()+"\", \"tipo\": \""+s.getId_Tipo()+"\"}}");
			if(i!=num) {
				risposta=risposta.concat(", ");
			}
		}
		return risposta.concat("]}");
	}
}
