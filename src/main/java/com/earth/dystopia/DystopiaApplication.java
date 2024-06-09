package com.earth.dystopia;

import com.earth.dystopia.upi.controllers.UserController;
import com.earth.dystopia.upi.errors.IncorrectDetailsException;
import com.earth.dystopia.upi.pojo.BankAccount;
import com.earth.dystopia.upi.pojo.enums.BankName;
import com.earth.dystopia.upi.pojo.request.CreateUserRequest;
import com.earth.dystopia.upi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

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

		try {
			userService.createUser(new CreateUserRequest("9999999999", "User3"));
		} catch (IncorrectDetailsException e) {
			System.out.println("Unexpected Error thrown");
		}

		try {
			userService.addBankAccount("1111111111", BankAccount.builder()
					.accountNumber(123L)
					.balance(3000L)
					.bankName(BankName.BOB)
					.bankTransactions(new ArrayList<>())
					.isPrimary(true)
					.build());
		} catch (IncorrectDetailsException e) {
			System.out.println("Should not print");
		}

		try {
			userService.addBankAccount("9999999999", BankAccount.builder()
					.accountNumber(123L)
					.balance(3000L)
					.bankName(BankName.BOB)
					.bankTransactions(new ArrayList<>())
					.isPrimary(true)
					.build());
		} catch (IncorrectDetailsException e) {
			System.out.println("Should print");
		}

		try {
			userService.addBankAccount("9999999999", BankAccount.builder()
					.accountNumber(456L)
					.balance(4000L)
					.bankName(BankName.CHASE)
					.bankTransactions(new ArrayList<>())
					.isPrimary(true)
					.build());
		} catch (IncorrectDetailsException e) {
			System.out.println("Should not print");
		}


	}

}
