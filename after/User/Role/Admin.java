package User.Role;

import java.util.Scanner;

import User.User;

public class Admin extends User {
	public Admin(String username, String password, String name) {
		super(username, password, name);
	}

	@Override
	public int showMenu() {
		int chooseMenu;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Choose action:");
		System.out.println("1. Show articles");
		System.out.println("2. Add articles");
		System.out.println("3. Show users");
		System.out.println("4. Add user");
		System.out.print("> Your choice: ");
		chooseMenu = s.nextInt();
		
		return chooseMenu;
	}
}
