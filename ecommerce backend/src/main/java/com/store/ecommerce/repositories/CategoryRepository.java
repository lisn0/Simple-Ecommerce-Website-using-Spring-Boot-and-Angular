package com.store.ecommerce.repositories;

import com.store.ecommerce.models.Category;
import com.store.ecommerce.models.Product;
import com.store.ecommerce.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
//	Category findByName(String categoryName);
	Optional<Category> findByName(String category_name);

	Optional<Category> findById(String id);

	void deleteByName(String category_name);
}
