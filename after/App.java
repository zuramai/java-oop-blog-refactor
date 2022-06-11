import java.util.Vector;
import java.util.Locale.Category;

import Article.Article;
import Article.ArticleCategory;
import Auth.Auth;
import User.User;
import User.Role.Roles;
import utils.Scan;

public class App {
	public Vector<User> users = new Vector<>();
	public Vector<ArticleCategory> categories = new Vector<>();
	public Vector<Article> articles = new Vector<>();
	public Auth auth = new Auth();
	
	public void run() {
		this.init();

		this.login();
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
		System.out.println("Sign in");
		
		boolean isLoggedIn = false;
		
		while(isLoggedIn == false) {
			System.out.print("Your username: ");
			String username = Scan.scanString();
			
			System.out.print("Your Password: ");
			String password = Scan.scanString();
			
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
		while(chooseMenu != 5) {
			if(chooseMenu == 1) this.showArticles();
			else if(chooseMenu == 2) this.addArticle();
			else if(chooseMenu == 3) this.showUsers();
			else if(chooseMenu == 4) this.addUser();
		}

		System.out.println("Thank you for using the application!");
	}

	public void printCategories() {
		System.out.println("> Category list");

		for(ArticleCategory category : this.categories) {
			System.out.println("- "+category.getName());
		}
	}
	
	public void addUser() {
		System.out.println("======= Add User ========");
		System.out.println("Username: ");
		String username = Scan.scanString();
		System.out.println("Password: ");
		String password = Scan.scanString();
		System.out.println("Name: ");
		String name = Scan.scanString();
		System.out.println("Role [Member/Admin]: ");
		String roleString = Scan.scanString();
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
		System.out.println("====== User List ======");
		for(User user : this.users) {
			System.out.println("- Name: " + user.getName());
			System.out.println("  Username"+user.getUsername());
			System.out.println("  Password"+user.getPassword());
			System.out.println("  Role"+user.getRole());
		}
	}
	
	public void showArticles() {
		System.out.println("====== Article List ======");
		for(Article article : this.articles) {
			article.show();
		}
	}
	
	public void addArticle() {
		System.out.println("======= Add Article ========");
		System.out.println("Title: ");
		String title = Scan.scanString();
		System.out.println("Content: ");
		String content = Scan.scanString();

		ArticleCategory category;

		// Validate category
		do {
			System.out.println("Category: ");
			String categoryString = Scan.scanString();
			category = getCategory(categoryString);
		} while(category == null);

		Article article = new Article(category, title, content, this.auth.getLoggedInUser());

		this.articles.add(article);
	}
}
