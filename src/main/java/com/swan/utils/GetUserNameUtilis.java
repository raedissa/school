package com.swan.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class GetUserNameUtilis {
	public String GetUserName() {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName;
		if (auth.getName().equals("anonymousUser")) {
			userName = "";
		} else {
			userName = auth.getName();
		}
		return userName;
	}

}
