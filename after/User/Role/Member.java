package User.Role;

import User.User;
import utils.Scan;

public class Member extends User {
	public Member(String username, String password, String name) {
		super(username, password, name);
	}

	@Override
	public int showMenu() {
		int chooseMenu;
		
		System.out.println("Choose action:");
		System.out.println("1. Show articles");
		System.out.println("2. Add articles");
		System.out.print("> Your choice: ");
		chooseMenu = Scan.scanInteger();
		
		return chooseMenu;
	}

	@Override
	public String getRole() {
		return "Member";
	}
}
