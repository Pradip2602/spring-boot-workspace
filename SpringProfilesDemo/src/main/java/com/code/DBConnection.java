package com.code;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBConnection {

	@Value("${dbusername}")
	private String username;

	@Value("${dbpassword}")
	private String password;

	@PostConstruct
	public void init() {
		System.out.println("DB Connection init Details : ");
		System.out.println("Username : " + username);
		System.out.println("Password : " + password);
	}

}
