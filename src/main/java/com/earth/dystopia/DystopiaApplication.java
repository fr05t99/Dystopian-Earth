package com.earth.dystopia;

import com.earth.dystopia.upi.controllers.UserController;
import com.earth.dystopia.upi.errors.IncorrectDetailsException;
import com.earth.dystopia.upi.pojo.request.CreateUserRequest;
import com.earth.dystopia.upi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DystopiaApplication {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DystopiaApplication.class, args);
		UserService userService = new UserService();

		try {
			userService.createUser(new CreateUserRequest("1111111111", "User1"));
		} catch (IncorrectDetailsException e) {
			System.out.println("No Error should be thrown");
		}

		try {
			userService.createUser(new CreateUserRequest("1111111111", "User2"));
		} catch (IncorrectDetailsException e) {
			System.out.println("Expected Error thrown");
		}
	}

}
