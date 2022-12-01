package com.project.comunepulito;

public class LoginBody {
	private String email;
	private String password;
	private boolean isGestore;
	
	public LoginBody(String email, String password, boolean isGestore) {
		super();
		this.email = email;
		this.password = password;
		this.isGestore = isGestore;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isGestore() {
		return isGestore;
	}
	public void setGestore(boolean isGestore) {
		this.isGestore = isGestore;
	}
}
