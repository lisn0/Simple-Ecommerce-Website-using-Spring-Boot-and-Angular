package com.store.ecommerce.repositories;

import com.store.ecommerce.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends MongoRepository<Seller, String>{
    List<Seller> findByFirstName(String firstName);
    Optional<Seller> findById(String id);
}
