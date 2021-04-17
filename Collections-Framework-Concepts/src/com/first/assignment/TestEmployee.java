package com.first.assignment;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestUtilEmployee employeeUtil = new TestUtilEmployee();
		Employee e1 = new Employee(1, "SK-B", "Mlore");
		Employee e2 = new Employee(2, "S-KB", "Blore");
		
		employeeUtil.addInput(e1);
		employeeUtil.addInput(e2);
		
		employeeUtil.display();
	}

}
