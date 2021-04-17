package com.basics.test;
import com.basics.util.HashSetUtil;

public class TestHashSetUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSetUtil hsObj = new HashSetUtil();
		hsObj.addPerson(new Person(1, "a", "z", 1));
		hsObj.addPerson(new Person(2, "b", "y", 1));
		hsObj.addPerson(new Person(3, "c", "x", 1));
		hsObj.addPerson(new Person(4, "d", "w", 1));
		hsObj.showAllPersons();
	}

}
