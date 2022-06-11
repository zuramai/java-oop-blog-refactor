package Article;

import java.util.Date;

import User.User;
import utils.Slug;

public class Article {
	public String slug;
	public String title;
	public String content;
	public User author;
	public Date createdAt;
	public ArticleCategory category;
	// ...
	
	 // Changed from enum to Category class
	public Article(ArticleCategory category, String title, String content, User author) {
		this.category = category;
		this.title = title;
		this.content = content;
		this.createdAt = new java.util.Date();
		this.author = author;
		this.slug = Slug.makeSlug(this.title);
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public ArticleCategory getCategory() {
		return category;
	}

	public void setCategory(ArticleCategory category) {
		this.category = category;
	}
	
	
}
