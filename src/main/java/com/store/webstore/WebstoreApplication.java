package com.store.webstore;

import com.store.webstore.model.Product;
import com.store.webstore.model.ProductDescription;
import com.store.webstore.model.User;
import com.store.webstore.service.ProductService;
import com.store.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WebstoreApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(WebstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(1,"Deepak","9876543210");
		Product product = new Product(1,"card","toy",10);

		userService.addUser(user);
		productService.add(product);

		user = new User(2,"ManojK","9876543210");
		product = new Product(2,"Galaxy 9s","mobile",12000);

		userService.addUser(user);
		productService.add(product);

		product = new Product(3,"Iphone 5s","mobile",25000);
		product.setProductDescriptions(List.of(new ProductDescription("Great Product")));
		productService.add(product);
//		product = new Product(4,"Iphone XR","mobile",90000);
//		productService.add(product);
	}
}
