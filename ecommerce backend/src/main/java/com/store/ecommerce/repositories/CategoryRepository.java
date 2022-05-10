package com.store.ecommerce.repositories;

import com.store.ecommerce.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
	Category findByName(String categoryName);
}
