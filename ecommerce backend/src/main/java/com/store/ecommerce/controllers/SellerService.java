package com.store.ecommerce.controllers;

import com.store.ecommerce.models.Seller;
import com.store.ecommerce.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/seller/")
public class SellerService {
    @Autowired
    private SellerRepository _sellerRepository;

    @GetMapping(path = "sellers-list")
    public List<Seller> getAllCategoriesFromMongoDB(){
        return _sellerRepository.findAll();
    }
    
    @GetMapping(path = "/{seller_id}")
    public Seller getSeller(@PathVariable("seller_id") String seller_id){
        return _sellerRepository.findById(seller_id).orElse(new Seller());
    }

    @PostMapping(path = "save-seller")
    public void insert(@RequestBody Seller seller) {
    	_sellerRepository.save(seller);
    }
    
    @DeleteMapping("delete-seller/{seller_id}")  
    public void deleteSeller(@PathVariable("seller_id") String seller_id) {  
        _sellerRepository.deleteById(seller_id);  
    }  

    @PostMapping("update-seller/{seller_id}")  
    public void updateSeller(@RequestBody Seller seller,@PathVariable("seller_id") String seller_id) {  
        seller.setId(seller_id);  
        _sellerRepository.save(seller);  
    }  
}
