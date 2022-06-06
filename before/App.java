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

		this.login();
	}
	
	public void init() {
		// Create user on application start
		users.add(User.create("Admin", "ahmad", "saugi", "Ahmad Saugi"));
		users.add(User.create("Member", "john", "doe", "John Doe"));
		users.add(User.create("Admin", "alvi", "alvi", "Alvi Kusuma"));
		users.add(User.create("Member", "lo", "rencia", "Lorencia"));
		users.add(User.create("Member", "evan", "you", "Evan You"));
	}
	
	public void login() {
		this.mainMenu();
	}
	
	public void logout() {
		this.auth.logout();
		System.out.println("Success logout!");
		
		// Go back to login page
		this.login();
	}
	
	public void mainMenu() {
		
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
			System.out.println("- Title: " + article.getTitle());
			System.out.println("  Slug: " + article.getSlug());
			System.out.println("  Category: " + article.getCategory().getName());
			System.out.println("  Content: " + article.getContent());
			System.out.println("  Author: " + article.getAuthor().getName());
			System.out.println("  Created At: " + article.getCreatedAt().toString());
		}
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
