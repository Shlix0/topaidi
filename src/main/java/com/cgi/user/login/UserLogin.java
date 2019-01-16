package com.cgi.user.login;

import com.cgi.model.Login;
import com.cgi.model.User;

public class UserLogin {
	
	private Login login;
	private User user;

	public UserLogin() {
	}

	public UserLogin(Login login, User user) {
		this.login = login;
		this.user = user;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
