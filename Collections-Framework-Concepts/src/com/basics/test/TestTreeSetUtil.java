package com.basics.test;

import com.basics.util.TreeSetUtil;

public class TestTreeSetUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSetUtil tsObj = new TreeSetUtil();
		tsObj.addIntegers(5);
		tsObj.addIntegers(4);
		tsObj.addIntegers(3);
		tsObj.addIntegers(2);
		tsObj.addIntegers(1);
		tsObj.addIntegers(1);
		tsObj.showIntegerTreeSet();
		System.out.println("++++++Person TreeSet+++++++");
		tsObj.addPerson(new Person(1, "a", "z", 1));
		tsObj.addPerson(new Person(2, "b", "y", 1));
		tsObj.addPerson(new Person(3, "c", "x", 1));
		tsObj.addPerson(new Person(4, "d", "w", 1));
		tsObj.showPersonTreeSet();
	}

}
