package com.practice.daos;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {

	public int[] retreiveAllData() {
		return new int[] {1,2,3,4,5};
	}

}
