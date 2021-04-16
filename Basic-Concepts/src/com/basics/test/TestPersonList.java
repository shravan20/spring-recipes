package com.basics.test;

import java.util.LinkedList;

import com.basics.test.Person;

public class TestPersonList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Person> list = new LinkedList<>();
		list.add(new Person(1,"A","B",10));
		list.add(new Person(2,"AA","BB",10));
		list.add(new Person(3,"C","D",10));
		list.add(new Person(4,"CC","DD",10));
		list.add(new Person(5,"E","F",10));
		System.out.println(list);	
		System.out.println("------------------------------");
		list.addFirst(new Person(0,"X","Y",10));
		list.addLast(new Person(6,"XX","YY",10));
		System.out.println(list);	
		System.out.println("------------------------------");
		list.remove(list.size()-1);
		list.remove(0);
		System.out.println(list);	
		System.out.println("------------------------------");
	}

}
