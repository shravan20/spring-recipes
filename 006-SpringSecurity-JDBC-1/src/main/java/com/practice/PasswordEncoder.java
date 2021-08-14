package com.practice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main() {
		
		String encoded = new BCryptPasswordEncoder().encode("password");
		System.out.println(encoded);
		
	}
	
}
