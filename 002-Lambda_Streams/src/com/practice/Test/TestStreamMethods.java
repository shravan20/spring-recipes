package com.practice.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class TestStreamMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(2,3,4,5,6,7);
		List<Integer> square = numbers.stream().map(x -> x*x).collect(Collectors.toList());
		System.out.println("Squares::"+square);
		
		
	    List<String> names = Arrays.asList("Reflection","Collection","Stream");
		List<String> result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
		System.out.println("Result::"+result);
		
	  
	    Set<Integer> squareSet = numbers.stream().map(x->x*x).collect(Collectors.toSet());
	    System.out.println("Before SquareSet"+squareSet);
	     
	    
	    System.out.println("After SquareSet"+numbers.stream().map(x->x*x));

	    numbers.stream().map(x->x*x).forEach(y->System.out.println("ForEach - Numbers::"+y));
	    
	}

}
