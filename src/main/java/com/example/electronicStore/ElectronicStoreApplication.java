package com.example.electronicStore;

import com.example.electronicStore.entities.User;
import com.example.electronicStore.repositories.UserRepository;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ElectronicStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
	}


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public void run(String... args) throws Exception {

		User user = userRepository.findByUsername("saj").orElse(null);
		if(user==null)
		{
			 user = new User();
			user.setUsername("saj");
			user.setPassword(passwordEncoder.encode("saj"));
			user.setRole("user");
			userRepository.save(user);
			System.out.println("User is created");
		}


	}
}
