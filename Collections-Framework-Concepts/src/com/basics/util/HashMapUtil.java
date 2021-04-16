package com.basics.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.basics.test.Person;

public class HashMapUtil {

	private HashMap<Integer, Person> map;
	
	public HashMapUtil() {
		map = new HashMap <>();
	}
	
	public void addPerson(Person person) {
		map.put(person.getId(), person);
	}
	
	public void traverseByKeys() {
		Iterator<Integer> itr = map.keySet().iterator();
		while(itr.hasNext())
			System.out.println("Key =>"+itr.next()+"||Value =>"+map.get(itr.next()));
	}
	
	public void traverseByEntries() {
		
		Iterator<Map.Entry<Integer, Person>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Person> entry = itr.next();
			System.out.println("Key::"+entry.getKey()+"  || Value::" + entry.getValue());
		}
	}
	
}
