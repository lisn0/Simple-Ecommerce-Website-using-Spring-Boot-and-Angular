package com.store.ecommerce.controllers;

import com.store.ecommerce.models.Category;
import com.store.ecommerce.models.Seller;
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
    
//    @GetMapping(path = "find")
//    public Category getCategoryFromMongoDB(@RequestParam(value = "name") String name){
//        return _categoryMongoRepository.findByName(name);
//    }

//    @GetMapping(path = "findall")
//    public List<Category> getAllCategoriesFromMongoDB(){
//        return _categoryMongoRepository.findAll();
//    }
    @GetMapping(path = "category-list")
    public List<Category> getAllCategoriesFromMongoDB(){
        return _categoryMongoRepository.findAll();
    }


    @GetMapping(path = "/{category_id}")
    public Category getCategory(@PathVariable("category_id") String category_id){
        return _categoryMongoRepository.findById(category_id).orElse(new Category());
    }

    @PostMapping(path = "save-category")
    public void insert(@RequestBody Category category) {
        _categoryMongoRepository.save(category);
    }

    @DeleteMapping("delete-category/{category_id}")
    public void deleteCategory(@PathVariable("category_id") String category_id) {
        _categoryMongoRepository.deleteById(category_id);
    }

    @PostMapping("update-category/{category_id}")
    public void updateCategory(@RequestBody Category category,@PathVariable("category_id") String category_id) {
        category.setId(category_id);
        _categoryMongoRepository.save(category);
    }



}
