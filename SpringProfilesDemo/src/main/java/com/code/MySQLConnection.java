package com.code;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dev")
public class MySQLConnection {

	@Value("${dbusername}")
	private String username;

	@Value("${dbpassword}")
	private String password;

	@PostConstruct
	public void init() {
		System.out.println("MYSQL Connection init Details : ");
		System.out.println("Username : " + username);
		System.out.println("Password : " + password);
	}

}
