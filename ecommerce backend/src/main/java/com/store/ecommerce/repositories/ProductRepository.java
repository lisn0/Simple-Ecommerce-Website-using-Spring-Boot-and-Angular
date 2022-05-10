package com.store.ecommerce.repositories;

import com.store.ecommerce.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	Product findByName(String name);
	Optional<Product> findById(String id);
}
