package com.project.comunepulito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserSignupController {
	@Autowired
	private UtenteRepository utenteRepository;
	
	@PostMapping("/signup")
	public SignupResponse UserSignin(@RequestBody SignupBody signupBody) {		
		try{	
			Utente n = new Utente();
			n.setNome(signupBody.getNome());
			n.setCognome(signupBody.getCognome());
			n.setEmail(signupBody.getEmail());
			n.setPwd(signupBody.getPassword());
			n.setBilancio(0);
			n.setBan(false);
			n.setWarn(0);
			utenteRepository.save(n);
			return new SignupResponse(true,new UserLogin(true, n.getId().toString(), n.getNome(),n.getCognome()));
		}catch (DataIntegrityViolationException e) {
			System.out.println("Email gia' utilizzata.");//Autoesplicativo, email è UNIQUE
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Utente già registrato.");
		}
	}
}
