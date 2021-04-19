package com.basics.test;

import java.util.Stack;

public class TestPersonStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person();
		Person p2 = new Person(1,"S", "K", 23);
		System.out.println("---------------------------------------------");
		System.out.println("P1 Name:"+p1.getFirstName()+" "+p1.getLastName());
		System.out.println("---------------------------------------------");
		System.out.println("P2 Name:"+p2.getFirstName()+" "+p2.getLastName());
		
		p1.setFirstName("S");
		p1.setLastName("K");
		p1.setAge(24);
		p1.setId(2);
		System.out.println("---------------------------------------------");
		System.out.println("P1 Name:"+p1.getFirstName()+" "+p1.getLastName());
		
		Stack<Person> stck = new Stack<>();
		stck.push(p1);
		stck.push(p2);
		stck.push(new Person(3,"A","B",22));
		System.out.println("Stack[]::"+stck);
		
		
		
	}

}
