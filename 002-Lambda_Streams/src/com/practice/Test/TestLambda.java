package com.practice.Test;

import com.practice.interfaces.MathOperation;

public class TestLambda {
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
