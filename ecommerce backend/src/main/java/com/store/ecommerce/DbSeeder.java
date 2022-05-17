package com.store.ecommerce;


import com.store.ecommerce.models.Category;
import com.store.ecommerce.models.Product;
import com.store.ecommerce.models.Seller;
import com.store.ecommerce.repositories.CategoryRepository;
import com.store.ecommerce.repositories.ProductRepository;
import com.store.ecommerce.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner{
    @Autowired
    private ProductRepository _productReposirory;
    @Autowired
    private SellerRepository _sellerRepository;
    @Autowired
    private CategoryRepository _categoryRepository;


    @Override
    public void run(String... strings) throws Exception {
        _sellerRepository.deleteAll();
        _productReposirory.deleteAll();
        _categoryRepository.deleteAll();

        Seller seller1 = new Seller("1e5", "3ez dine", "mraweb");
        Seller seller2 = new Seller("1e7", "salih", "salah");
        Seller seller3 = new Seller("1e8", "hammadi", "mohamed");
        _sellerRepository.save(seller1);
        _sellerRepository.save(seller2);
        _sellerRepository.save(seller3);

        Category cat1 = new Category("Books");
        Category cat2 = new Category("Food");

        _categoryRepository.save(cat1);
        _categoryRepository.save(cat2);

        Product product1 = new Product("Effective Java", "learn java ",125,"https://www.pearsonhighered.com/assets/bigcovers/0/1/3/2/0132778041.jpg",cat1,seller1);
        Product product2 = new Product("Thinking in Java", "learn java ",50,"https://images-na.ssl-images-amazon.com/images/I/51S8VRHA2FL._SX357_BO1,204,203,200_.jpg",cat1,seller2);
        Product product3 = new Product("McDonald", "McDonald‘s Food",76,"http://cdn1.thecomeback.com/wp-content/uploads/2017/05/mcdonalds_food-832x447.png",cat2,seller3);
        _productReposirory.save(product1);
        _productReposirory.save(product2);
        _productReposirory.save(product3);
    }
}
