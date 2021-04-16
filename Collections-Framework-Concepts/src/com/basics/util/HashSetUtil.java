package com.basics.util;

import java.util.HashSet;
import java.util.Iterator;

import com.basics.test.Person;


public class HashSetUtil {

	private HashSet<Person> hs;
	
	public HashSetUtil() {
		hs = new HashSet<>();
	}
	
	public void addPerson(Person person) {
		hs.add(person);
	}
	
	public void showAllPersons() {
		Iterator<Person> itr = hs.iterator();
		while(itr.hasNext()) 
			System.out.println(itr.next());
	}
	
	
}