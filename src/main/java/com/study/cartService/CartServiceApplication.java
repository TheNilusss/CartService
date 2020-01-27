package com.study.cartService;

import com.study.cartService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartServiceApplication implements CommandLineRunner {

	@Autowired
	private CartRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//repository.deleteAll();
	}
}
