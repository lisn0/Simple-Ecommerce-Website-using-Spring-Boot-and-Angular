package com.store.ecommerce.controllers;

import com.store.ecommerce.models.Category;
import com.store.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/category/")
public class CategoryService {
    @Autowired
    private CategoryRepository _categoryMongoRepository;
    
    @GetMapping(path = "find")
    public Category getCategoryFromMongoDB(@RequestParam(value = "name") String name){
        return _categoryMongoRepository.findByName(name);
    }

    @GetMapping(path = "findall")
    public List<Category> getAllCategoriesFromMongoDB(){
        return _categoryMongoRepository.findAll();
    }
    
    @PostMapping
    public void insert(@RequestBody Category category) {
    	_categoryMongoRepository.save(category);
    }
}
