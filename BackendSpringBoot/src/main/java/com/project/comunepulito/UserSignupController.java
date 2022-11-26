package com.project.comunepulito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserSignupController {
	
	
	@PostMapping("/signup")
	public SignupResponse UserSignin(@RequestBody SignupBody signupBody) {
		try{	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");
			String query="SELECT * FROM comunepulito.utente WHERE email='"+signupBody.getEmail()+"';";//Controllo che non ci siano altri utenti già registrati con questo indirizzo email
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			if (!rs.next()) {//caso in cui l'entità non è stata trovata nel db:Utente da aggiungere.
				query=String.format("INSERT INTO comunepulito.utente(nome,cognome,email,pwd,bilancio,warn,ban) VALUES(?,?,?,?,?,?,?);");
				PreparedStatement psm =conn.prepareStatement(query);//Preparo la query
				psm.setString(1, signupBody.getNome());
				psm.setString(2, signupBody.getCognome());
				psm.setString(3, signupBody.getEmail());
				psm.setString(4, signupBody.getPassword());
				psm.setInt(5, 0);
				psm.setInt(6, 0);
				psm.setInt(7, 0);
				psm.execute();//Eseguo la query INSERT
				conn.close();
				return new SignupResponse(false,new UserLogin(true,UserLoginController.generaToken(signupBody.getEmail(),signupBody.getPassword())));//restituisco un feedback e il token di autenticazione
			}					
		}catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Email gia' utilizzata.");//Autoesplicativo, email è UNIQUE
			return new SignupResponse(true,null);
		}catch (Exception e) {
			System.out.println("errore");
			e.printStackTrace();
		}
		return new SignupResponse(true,null);		
	}

	

}
