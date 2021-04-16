package com.first.assignment;

import java.util.ArrayList;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> students  = new ArrayList<>();
		students.add(new Student("Shravan"));
		students.add(new Student("Kumar"));
		
		Student s = new Student("Shravan"); 
		System.out.println("Contains or not:"+students.contains(s)); 
	}

}
