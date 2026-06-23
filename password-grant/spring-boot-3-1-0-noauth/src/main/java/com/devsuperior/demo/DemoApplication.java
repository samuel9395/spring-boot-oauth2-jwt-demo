package com.devsuperior.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ENCODE = " + passwordEncoder.encode("123456"));

		String hashedPassword = "$2a$10$VS8o2TfCXrThpmrrImuDVu.75o.6aBzFu1GRKTzELeEDJwe4LhgfG";
		boolean result = passwordEncoder.matches("123456", hashedPassword);
		System.out.println("RESULTADO = " + result);
	}
}
