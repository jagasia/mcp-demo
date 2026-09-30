package com.example.productapi;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }

    // Seed a few products the first time the database is empty
    @Bean
    CommandLineRunner seed(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Product(null, "Laptop", 55000.0, 10));
                repo.save(new Product(null, "Mouse", 499.0, 100));
                repo.save(new Product(null, "Keyboard", 1299.0, 50));
            }
        };
    }
}
