package com.practice.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String authorName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="author_book",
			joinColumns = {@JoinColumn(name="author_id")},
			inverseJoinColumns = {@JoinColumn(name="book_id")}
			)
	private Set<Book> books;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
