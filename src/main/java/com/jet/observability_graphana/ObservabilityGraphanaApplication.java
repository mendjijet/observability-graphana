package com.jet.observability_graphana;

import com.jet.observability_graphana.entity.Product;
import com.jet.observability_graphana.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservabilityGraphanaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ObservabilityGraphanaApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(ProductRepository productRepository) {
    return args -> {
      productRepository.save(Product.builder().name("Computer").price(12000).build());
      productRepository.save(Product.builder().name("smart Phone").price(5000).build());
      productRepository.save(Product.builder().name("Printer").price(3500).build());
      productRepository.findAll().forEach(System.out::println);
    };
  }
}
