package com.jet.observability_graphana.repository;

import com.jet.observability_graphana.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project observability-graphana
 * @version 1.0
 * @author MENDJIJET
 * @since 21/08/2024
 */
public interface ProductRepository extends JpaRepository<Product, Long> {}
