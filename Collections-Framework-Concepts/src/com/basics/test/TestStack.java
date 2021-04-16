package com.basics.test;

import java.util.Iterator;
import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {

		Stack<Integer> stck = new Stack<Integer>();
		stck.push(1);
		stck.push(2);
		stck.push(3);
		stck.push(4);
		stck.push(5);
		System.out.println(stck);
		boolean isPresent = stck.contains(3);
		System.out.println("isPresent(30)::"+isPresent);
		
		System.out.println("________________________________________");
		System.out.println("Elements in stack using for-loop:");
		for(int i=0;i<stck.size(); i++)
			System.out.println(stck.elementAt(i));
		
		System.out.println("________________________________________");
		System.out.println("Elements in stack using iterator():");
		Iterator itr = stck.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		System.out.println("Elements in stack using popping:");
		System.out.println(stck);
		stck.pop();
		System.out.println(stck);
		stck.pop();
		System.out.println(stck);
		stck.pop();
		System.out.println(stck);
		stck.pop();
		System.out.println(stck);
			

	}

}
