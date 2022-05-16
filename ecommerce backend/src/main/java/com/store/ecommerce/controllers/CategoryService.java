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
    
//    @GetMapping(path = "find")
//    public Category getCategoryFromMongoDB(@RequestParam(value = "name") String name){
//        return _categoryMongoRepository.findByName(name);
//    }

    @GetMapping(path = "findall")
    public List<Category> getAllCategoriesFromMongoDB(){
        return _categoryMongoRepository.findAll();
    }


    @GetMapping(path = "/{category_name}")
    public Category getCategory(@PathVariable("category_name") String category_name){
        return _categoryMongoRepository.findByName(category_name).orElse(new Category());
    }

    @PostMapping(path = "save-category")
    public void insert(@RequestBody Category category) {
        _categoryMongoRepository.save(category);
    }

    @DeleteMapping("delete-category/{category_name}")
    public void deleteCategory(@PathVariable("category_name") String category_name) {
        _categoryMongoRepository.deleteByName(category_name);
    }

    @PostMapping("update-category/{category_name}")
    public void updateCategory(@RequestBody Category category,@PathVariable("category_name") String category_name) {
        category.setName(category_name);
        _categoryMongoRepository.save(category);
    }



}
