package com.basics.test;

import com.basics.util.HashMapUtil;


public class TestHashMapUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapUtil hmObj = new HashMapUtil();
		hmObj.addPerson(new Person(1, "a", "z", 1));
		hmObj.addPerson(new Person(2, "b", "y", 1));
		hmObj.addPerson(new Person(3, "c", "x", 1));
		hmObj.addPerson(new Person(4, "d", "w", 1));
		System.out.println("==========Traverse By Keys==========");
		hmObj.traverseByKeys();
		System.out.println("==========Traverse By Entries==========");
		hmObj.traverseByKeys();
	}
}
