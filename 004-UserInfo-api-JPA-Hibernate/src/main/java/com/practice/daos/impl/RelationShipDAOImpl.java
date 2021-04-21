package com.practice.daos.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.models.Address;
import com.practice.models.Author;
import com.practice.models.Book;
import com.practice.models.Employee;
import com.practice.models.Group;
import com.practice.models.Story;

@Repository 
public class RelationShipDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void testOneToOne() {
		Session sess = sessionFactory.openSession();
		Transaction tr = sess.beginTransaction();
		Employee emp = null;
		Address a1=null;
		
		emp = new Employee();
		emp.setName("Ameya Joshi");
		a1 = new Address();
		a1.setAddress("Kothrud, Pune");
		
		emp.setAddress(a1);
		a1.setEmployee(emp);
		
		sess.save(emp);
		sess.flush();
		Query<Employee> query = sess.createQuery("from Employee");
		List<Employee> list = query.list();
		
		for(Employee e:list) {
			System.out.println(e.getId()+":"+e.getName()+":"+e.getAddress().getCountry());
		}
		tr.commit();
		sess.close();
	}
	
	public void testOneToMany() {
		Session sess = sessionFactory.openSession();
		Transaction tr = sess.beginTransaction();
		Group group = new Group();
		group.setName("Sports");
		ArrayList<Story> stories = new ArrayList<>();
		
		Story s1 = new Story();
		s1.setInfo("The Allegations - Life of a Player");
		stories.add(s1);
		
		Story s2 = new Story();
		s2.setInfo("Cancer of Match Fixing");
		stories.add(s2);

		Story s3 = new Story();
		s3.setInfo("Sachin - Master Blaster");
		stories.add(s3);

		
		group.setStories(stories);
		
		Serializable id = sess.save(group);
		sess.flush();
		
		Group g = (Group) sess.load(Group.class, id);
		
		System.out.println("GROUP ID::"+ g.getId() + " GROUP NAME::" + g.getName());
		List<Story> groupStories = g.getStories();
		System.out.println("STORIES::");
		for (Story story : groupStories) {
			System.out.println(story.getId()+"::"+story.getInfo());
		}
		
		tr.commit();
		sess.close();
	
	}

	public void testManyToOne() {
		Session sess = sessionFactory.openSession();
		Story story = (Story)sess.load(Story.class, 5);
		
		System.out.println(story.getId()+":"+story.getInfo());
		
		Group group = story.getGroup();
		System.out.println(group.getId()+":"+group.getName());
		sess.close();
	}
	
	public void testManytoMany() {
		Session sess = sessionFactory.openSession();
		Transaction tr = sess.beginTransaction();
		
		Author a1 = new Author();
		a1.setAuthorName("Sachin");
		
		Book b1 = new Book();
		b1.setBookName("My Pakistan Tour");
		
		Book b2 = new Book();
		b1.setBookName("My Autralian Tour");
	
		
		Book b3= new Book();
		b1.setBookName("Tour to Land of English ");
		
		Book b4= new Book();
		b1.setBookName("India's World Cup Triumph");
		
		Set<Book> books = new HashSet<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		
		
		
		Serializable authorId = sess.save(a1);
		sess.flush();
		
		Book b5 = new Book();
		b5.setBookName("Gully Cricket");
		
		Set<Author> authors = new HashSet<>();
		
		Author a2 = new Author();
		a2.setAuthorName("Viru");
		
		Author a3 = new Author();
		a3.setAuthorName("Zaheer");
		
		Author a4 = new Author();
		a4.setAuthorName("Zaheer");

		authors.add(a2);
		authors.add(a3);
		authors.add(a3);
		authors.add(a4);
		authors.add(a1);
		
		b5.setAuthors(authors);
		
		Serializable bookId = sess.save(b5);
		
		Author a= (Author)sess.get(Author.class, authorId);
		System.out.println(a.getId()+":"+a.getAuthorName());
		
		Set<Book> bookSet = a.getBooks();
		
		for (Book b : bookSet) {
			System.out.println(b.getId()+":"+b.getBookName());
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		
		Book bk = (Book) sess.get(Book.class, bookId);
		System.out.println(bk.getId()+"::"+bk.getBookName());
		Set<Author> authorSet = bk.getAuthors();
		for (Author at : authorSet) {
			System.out.println(at.getId()+":"+at.getAuthorName());
		}
		tr.commit();
		sess.close();
	}
	
}
