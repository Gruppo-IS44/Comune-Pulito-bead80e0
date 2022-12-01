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
public class UserLoginController {
	@Autowired
	private UtenteRepository userRepository;
	
	@Autowired
	private GestoreRepository gestoreRepository;
	
	@PostMapping("/login")
	public UserLogin userLogin(	@RequestBody LoginBody loginBody) {
	    loginBody.setPassword(generaToken(loginBody.getPassword()));
		if (loginBody.isGestore()){
			try{
				Gestore gestore=gestoreRepository.findByEmail(loginBody.getEmail());
				if(gestore.getPwd().equals(loginBody.getPassword())) {//Autenticazione Riuscita!
					return new UserLogin(true,gestore.getPwd());
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
				return new UserLogin(true,utente.getPwd());
			}
			//Password Errata
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Gestore Inesistente.");
		}catch (NullPointerException e){//Autenticazione Fallita
			System.out.println("Utente Inesistente.");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Utente Inesistente.");
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Errore Interno al Server");
		}
	}

	static String generaToken(String pwd) {
		String x="";
		try {	
			MessageDigest digest = MessageDigest.getInstance("SHA-256");  //codifica dei token con algoritmo di hash SHA-256
			byte[] hash = digest.digest(pwd.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder(2 * hash.length);
		    for (int i = 0; i < hash.length; i++) {
		        String hex = Integer.toHexString(0xff & hash[i]);
		        if(hex.length() == 1) {
		            hexString.append('0');
		        }
		        hexString.append(hex);
		    }
		    x=hexString.toString();
		}catch(Exception e){
			System.out.println("Errore durante la generazione del token"); //non accadrà mai, ma ok
			e.printStackTrace();
		}	
		return x;
	}
}
