package com.project.comunepulito;

public class SignupResponse {//Classe delle risposte ad un Signup
	private boolean SignedUp;
	private UserLogin userLogin;
	public SignupResponse(boolean signedUp, UserLogin userLogin) {
		super();
		SignedUp = signedUp;
		this.userLogin = userLogin;
	}
	public boolean isSignedUp() {
		return SignedUp;
	}
	public void setSignedUp(boolean signedUp) {
		SignedUp = signedUp;
	}
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	

}
