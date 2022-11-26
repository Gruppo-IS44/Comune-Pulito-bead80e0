package com.project.comunepulito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserLoginController {
	private String TABELLA;//TODO usare gli enum
	private boolean successo;
	
	@GetMapping("/login")
	public UserLogin userLogin(	@RequestParam(value="email",defaultValue="goku") String email,
								@RequestParam(value="password",defaultValue="goku") String password,
								@RequestParam(value="isGestore",defaultValue="false") boolean isGestore) {
		TABELLA="utente";
		if (isGestore){
			this.TABELLA="gestore";
		}
		System.out.println(TABELLA);
	    //password=generaToken(mail,pwd);  TODO: Implementare la crittografia del token
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");
			String query="SELECT *\nFROM comunepulito."+TABELLA+"\nWHERE email='"+email+"' AND pwd='"+password+"';";
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			if (!rs.next()) {//caso in cui l'entità non è stata trovata nel db:autenticazione fallita
				System.out.println("Credenziali non valide.");
				successo=false;
			} else {//è superfluo usare un ciclo, la query restituirà sempre solo un risultato.
//					int id = rs.getInt("id_utente");
//					String nome=rs.getString("nome");
//					String cognome=rs.getString("cognome");
					String mail=rs.getString("email");
					String pwd=rs.getString("pwd");
//					int bilancio=rs.getInt("bilancio");
//					int warn=rs.getInt("warn");
//					int ban=rs.getInt("ban");
					successo=true;
				    password=generaToken(mail,pwd);
			}
			st.close();
		}catch (Exception e){
			System.out.println("Errore durante la connessione al DataBase.");
			e.printStackTrace();
		}
		return new UserLogin(successo,password);
	}

	static String generaToken(String mail, String pwd) {
		// TODO crittografia di email+password
		return pwd+mail;
	}
}
