package com.product.app;

import com.product.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
	SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		productService.printReport();
	}

}
