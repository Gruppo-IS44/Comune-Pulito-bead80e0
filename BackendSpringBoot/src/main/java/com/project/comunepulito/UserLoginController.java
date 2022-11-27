package com.project.comunepulito;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;  


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserLoginController {

	private boolean successo;
	private enum TABELLA {
		utente,
		gestore
		}
	
	@GetMapping("/login")
	public UserLogin userLogin(	@RequestParam(value="email",defaultValue="goku") String email,
								@RequestParam(value="password",defaultValue="goku") String password,
								@RequestParam(value="isGestore",defaultValue="false") boolean isGestore) {
		TABELLA tab=TABELLA.utente;
		if (isGestore){
			tab=TABELLA.gestore;
		}		
	    password=generaToken(email,password);
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");
			String query="SELECT *\nFROM comunepulito."+tab+"\nWHERE email='"+email+"' AND pwd='"+password+"';";
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			if (!rs.next()) {//caso in cui l'entità non è stata trovata nel db:autenticazione fallita
				successo=false;
				password="";
			} else {//è superfluo usare un ciclo, la query restituirà sempre solo un risultato.
//					int id = rs.getInt("id_utente");		Commentati per uso futuro
//					String nome=rs.getString("nome");
//					String cognome=rs.getString("cognome");
//					String mail=rs.getString("email");
//					String pwd=rs.getString("pwd");
//					int bilancio=rs.getInt("bilancio");
//					int warn=rs.getInt("warn");
//					int ban=rs.getInt("ban");
					successo=true;
			}
			st.close();
		}catch (Exception e){
			System.out.println("Errore durante la connessione al DataBase.");
			e.printStackTrace();
		}
		return new UserLogin(successo,password);
	}

	static String generaToken(String mail, String pwd) {
		String x="";
		try {	
			MessageDigest digest = MessageDigest.getInstance("SHA-256");  //codifica dei token con algoritmo di hash SHA-256
			byte[] hash = digest.digest((mail+pwd).getBytes(StandardCharsets.UTF_8));
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
