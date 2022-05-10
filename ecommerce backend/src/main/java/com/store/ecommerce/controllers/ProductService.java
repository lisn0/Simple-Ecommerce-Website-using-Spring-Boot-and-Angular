package com.store.ecommerce.controllers;

import com.store.ecommerce.models.Product;
import com.store.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/product/")
public class ProductService {
    @Autowired
    private ProductRepository _productRepository;


    @GetMapping(path = "products-list")
    public List<Product> getAllCategoriesFromMongoDB(){
        return _productRepository.findAll();
    }
    
    @PostMapping(path = "save-product")
    public void insert(@RequestBody Product product) {
    	_productRepository.save(product);
    }
    
    @DeleteMapping("delete-product/{product_id}")  
    public void deleteSeller(@PathVariable("product_id") String product_id) {  
    	_productRepository.deleteById(product_id);  
    }  
    
    @GetMapping(path = "/{product_id}")
    public Product getProduct(@PathVariable("product_id") String product_id){
    	Product product = _productRepository.findById(product_id).orElse(new Product()); 
        return product;
    }
    
    @PostMapping("update-product/{product_id}")  
    public void updateSeller(@RequestBody Product product,@PathVariable("product_id") String product_id) {  
        product.setId(product_id);  
        _productRepository.save(product);  
    }  
}
