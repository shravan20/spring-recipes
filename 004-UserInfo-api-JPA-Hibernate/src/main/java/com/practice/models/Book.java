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
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String bookName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="author_book",
			joinColumns = {@JoinColumn(name="book_id")},
			inverseJoinColumns = {@JoinColumn(name="author_id")}
			)	
	private Set<Author> authors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
}
