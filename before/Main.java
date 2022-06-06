import java.util.Scanner;

import User.User;


public class Main {
	
	public static void main(String[] args) {
		// Create users on application start
		users.add(User.create("Admin", "ahmad", "saugi", "Ahmad Saugi"));
		users.add(User.create("Member", "john", "doe", "John Doe"));
		users.add(User.create("Admin", "alvi", "alvi", "Alvi Kusuma"));
		users.add(User.create("Member", "lo", "rencia", "Lorencia"));
		users.add(User.create("Member", "evan", "you", "Evan You"));

		//		Prompt login form
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sign in");
		
		boolean isLoggedIn = false;
		
		while(isLoggedIn == false) {
			System.out.print("Your username: ");
			String username = scanner.next();
			
			System.out.print("Your Password: ");
			String password = scanner.next();
			
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
			
			if(!isLoggedIn) System.out.println("Wrong username or password. Try again.");
		}
		
		System.out.println("Success login! Welcome "+this.auth.getLoggedInUser().getName());

		// Login
		int chooseMenu = this.auth.getLoggedInUser().showMenu();
		
		while(chooseMenu != 5) {
			if(chooseMenu == 1) this.showArticles();
			else if(chooseMenu == 2) this.addArticle();
			else if(chooseMenu == 3) this.showUsers();
			else if(chooseMenu == 4) this.addArticle();
		}

		System.out.println("Thank you for using the application!");
	}
	
}
