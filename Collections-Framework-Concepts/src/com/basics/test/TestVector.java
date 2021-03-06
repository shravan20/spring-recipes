package com.basics.test;

import java.util.Vector;

public class TestVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> v = new Vector<>();
		System.out.println("<--Initial--> ");
		System.out.println("Capacity => "+v.capacity());
		System.out.println("Size     => "+v.size());
		for(int i=0;i<10;i++)
			v.addElement(10);
		System.out.println("----After adding 10----");
		System.out.println("Capacity => "+v.capacity());
		System.out.println("Size     => "+v.size());
		for(int i=0;i<20;i++)
			v.addElement(20);
		System.out.println("----After adding 15----");
		System.out.println("Capacity => "+v.capacity());
		System.out.println("Size     => "+v.size());
		
		System.out.println("<==================> ");
		
		
		Vector<Integer> vp = new Vector<>(5,1);
		System.out.println("<--Initial--> ");
		System.out.println("Capacity => "+vp.capacity());
		System.out.println("Size     => "+vp.size());
		for(int i=0;i<10;i++)
			vp.addElement(10);
		System.out.println("----After adding 10----");
		System.out.println("Capacity => "+vp.capacity());
		System.out.println("Size     => "+vp.size());
		for(int i=0;i<20;i++)
			vp.addElement(20);
		System.out.println("----After adding 15----");
		System.out.println("Capacity => "+vp.capacity());
		System.out.println("Size     => "+vp.size());
		
	}

}
