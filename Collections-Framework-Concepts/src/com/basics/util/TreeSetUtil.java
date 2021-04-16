package com.basics.util;

import java.util.Iterator;
import java.util.TreeSet;

import com.basics.test.Person;

public class TreeSetUtil {

	private TreeSet<Integer> tsInt;
	private TreeSet<Person> tsPerson;
	
	public TreeSetUtil() {
		tsInt = new TreeSet<>();
		tsPerson = new TreeSet<>();
	}
	
	public void addIntegers(int num) {
		tsInt.add(num);
	}
	
	public void showIntegerTreeSet() {
		Iterator<Integer> itr = tsInt.iterator();
		while(itr.hasNext()) {
			int num = itr.next();
			System.out.println(num);
		}
	}
	
	public void addPerson(Person person) {
		tsPerson.add(person);
	}
	
	public void showPersonTreeSet() {
		Iterator<Person> itr = tsPerson.iterator();
		while(itr.hasNext()) {
			Person person= itr.next();
			System.out.println(person);
		}
	}
	
		
}
