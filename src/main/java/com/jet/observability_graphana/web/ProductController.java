package com.jet.observability_graphana.web;

import com.jet.observability_graphana.entity.Product;
import com.jet.observability_graphana.model.Post;
import com.jet.observability_graphana.repository.ProductRepository;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

/**
 * @project observability-graphana
 * @version 1.0
 * @author MENDJIJET
 * @since 21/08/2024
 */
@RestController
public class ProductController {
  private ProductRepository productRepository;
  private RestClient restClient;

  public ProductController(ProductRepository productRepository, RestClient.Builder restClient) {
    this.productRepository = productRepository;
    this.restClient = RestClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
  }

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/posts")
  public List<Post> getAllPost() {
    return restClient
        .get()
        .uri("/posts")
        .retrieve()
        .body(new ParameterizedTypeReference<List<Post>>() {});
  }
}
