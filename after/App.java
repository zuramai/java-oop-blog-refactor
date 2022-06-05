import java.util.Scanner;
import java.util.Vector;
import java.util.Locale.Category;

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

	public void printCategories() {
		System.out.println("> Category list");

		for(ArticleCategory category : this.categories) {
			System.out.println("- "+category.getName());
		}
	}
	
	public void addUser() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("======= Add User ========");
		System.out.println("Username: ");
		String username = s.next();
		System.out.println("Password: ");
		String password = s.next();
		System.out.println("Name: ");
		String name = s.next();
		System.out.println("Role [Member/Admin]: ");
		String roleString = s.next();
		Roles role = roleString.equalsIgnoreCase("Admin") ? Roles.Admin : Roles.Member;
		
		User user = User.create(role, username, password, name);

		this.users.add(user);
	}

	public ArticleCategory getCategory(String category) {
		ArticleCategory articleCategory = null;
		for(ArticleCategory currentCategory : this.categories) {
			if(currentCategory.getName().equals(category)) articleCategory = currentCategory;
		}
		return articleCategory;
	}
	
	public void showUsers() {
		
	}
	
	public void showArticles() {
		
	}
	
	public void addArticle() {
		Scanner s = new Scanner(System.in);
		System.out.println("======= Add Article ========");
		System.out.println("Title: ");
		String title = s.next();
		System.out.println("Content: ");
		String content = s.next();

		ArticleCategory category;

		// Validate category
		do {
			System.out.println("Category: ");
			String categoryString = s.next();
			category = getCategory(categoryString);
		} while(category == null);

		Article article = new Article(category, title, content, this.auth.getLoggedInUser());

		this.articles.add(article);
	}
}
