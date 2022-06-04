package User;

import java.util.Date;


import User.Role.Admin;
import User.Role.Member;
import User.Role.Roles;

public abstract class User {
	private String username;
	private String password;
	private String name;
	private Date lastLogin;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastLogin = null;
	}
	
	public static User create(Roles role, String username, String password, String name) {
		if (role.equals(Roles.Member)) {
			return new Admin(username, password, name);
		} else {
			return new Member(username, password, name);
		}
	}
	
	public boolean checkCredentials(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
}
