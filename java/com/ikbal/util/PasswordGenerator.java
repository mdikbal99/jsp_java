package com.ikbal.util;


import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class PasswordGenerator {
    private static String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String Small_chars = "abcdefghijklmnopqrstuvwxyz";
    private static String numbers = "0123456789";
    private static String symbols = "!@#$%&*_";

	public  String auto_Password() {
		String values = Capital_chars + Small_chars + numbers + symbols;

		Random rndm_method = new Random();
		char[] password = new char[8];
		for (int i = 0; i < 8; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
		}
		return new String(password);
	}
	
}
