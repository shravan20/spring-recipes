package com.first.assignment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String pId, pName;
		
		HashMap<Integer,Product> p = new HashMap<>();
		
		for(int i=0;i<10;i++) {
			System.out.println("Enter the productId:");
			pId = input.nextLine();
			System.out.println("Enter the productName:");
			pName = input.nextLine();
			p.put(i,new Product(pId,pName));
		}
		
		boolean isCheck = true;

		Iterator<Integer> itr = p.keySet().iterator();
		String prodId = new String();
		while(isCheck) {
			System.out.println("Enter the ProductId:");
			prodId = input.nextLine();
			if(prodId=="0")
				break;
			while(itr.hasNext()){
				Product prod = p.get(itr.next());
				if(prod.getProductId().equals(prodId)) {
					System.out.println("Found");	
				}
				else {
					System.out.println("Found");
				}
			}
							
		}

	}

}
