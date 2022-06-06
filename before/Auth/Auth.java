package Auth;

import java.util.Vector;

import User.User;

public class Auth {
	private User loggedInUser;
	
	public boolean login(Vector<User> users, String username, String password) {
		// Logged in user
		User u = null;

		// uc = current user in loop
		for(User uc : users) {
			if(u.checkCredentials(username, password)) {
				u = uc;
				break;
			}
		}
		if(user == null) {
			return false;
		}
		
		user.setLastLogin(new java.util.Date());
		this.setLoggedInUser(user);
		
		return true;
		
	}
	
	public void logout() {
		loggedInUser = null;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
}
