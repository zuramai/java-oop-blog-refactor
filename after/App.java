import java.util.Scanner;
import java.util.Vector;

import Article.Article;
import Article.ArticleCategory;
import Auth.Auth;
import User.User;
import User.Role.Roles;

public class App {
	public Vector<User> users = new Vector<>();
	public Vector<ArticleCategory> categories = new Vector<>();
	public Vector<Article> articles = new Vector<>();
	public Auth auth = new Auth();
	
	public void run() {
		this.init();
	}
	
	public void init() {
		// Create user on application start
		users.add(User.create(Roles.Admin, "ahmad", "saugi", "Ahmad Saugi"));
		users.add(User.create(Roles.Member, "john", "doe", "John Doe"));
		users.add(User.create(Roles.Admin, "alvi", "alvi", "Alvi Kusuma"));
		users.add(User.create(Roles.Member, "lo", "rencia", "Lorencia"));
		users.add(User.create(Roles.Member, "evan", "you", "Evan You"));
	}
	
	public void login() {
//		Prompt login form
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sign in");
		
		boolean isLoggedIn = false;
		
		while(isLoggedIn = false) {
			System.out.print("Your username: ");
			String username = scanner.next();
			
			System.out.print("Your Password: ");
			String password = scanner.next();
			
			isLoggedIn = auth.login(users, username, password);
			
			if(!isLoggedIn) System.out.println("Wrong username or password. Try again.");
		}
		
		System.out.println("Success login! Welcome "+this.auth.getLoggedInUser().getName());
		
		this.mainMenu();
	}
	
	public void logout() {
		this.auth.logout();
		System.out.println("Success logout!");
		
		// Go back to login page
		this.login();
	}
	
	public void mainMenu() {
		int chooseMenu = this.auth.getLoggedInUser().showMenu();
		
		// One liner
		if(chooseMenu == 1) this.showArticles();
		else if(chooseMenu == 2) this.addArticle();
		else if(chooseMenu == 3) this.showUsers();
		else if(chooseMenu == 4) this.addArticle();
	}
	
	public void addUser() {
		
	}
	
	public void showUsers() {
		
	}
	
	public void showArticles() {
		
	}
	
	public void addArticle() {
		
	}
}
