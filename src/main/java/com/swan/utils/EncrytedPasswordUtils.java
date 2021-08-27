package com.swan.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
	public static String encrytePassword(String password) {
		final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
