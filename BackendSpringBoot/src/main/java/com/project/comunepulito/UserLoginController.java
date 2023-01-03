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
public class UserLoginController {
	@Autowired
	private UtenteRepository userRepository;
	
	@Autowired
	private GestoreRepository gestoreRepository;
	
	@PostMapping("/login")
	public UserLogin userLogin(@RequestBody LoginBody loginBody) {
		if (loginBody.isGestore()){
			try{
				Gestore gestore=gestoreRepository.findByEmail(loginBody.getEmail());
				if(gestore.getPwd().equals(loginBody.getPassword())) {//Autenticazione Riuscita!
					return new UserLogin(true,gestore.getId_gestore().toString());
				}
				//Password Errata
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Gestore Inesistente.");
			}catch (NullPointerException e){//Autenticazione Fallita
				System.out.println("Gestore Inesistente.");
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Gestore Inesistente.");
			}catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Errore Interno al Server");
			}
		}		
		try{
			Utente utente=userRepository.findByEmail(loginBody.getEmail());
			if(utente.getPwd().equals(loginBody.getPassword())) {//Autenticazione Riuscita!
				return new UserLogin(true,utente.getId().toString());
			}
			//Password Errata
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Utente Inesistente.");
		}catch (NullPointerException e){//Autenticazione Fallita
			System.out.println("Utente Inesistente.");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Utente Inesistente.");
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Errore Interno al Server");
		}
	}

}
