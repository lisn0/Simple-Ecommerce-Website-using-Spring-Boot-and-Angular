import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import {FormControl,FormGroup} from '@angular/forms';
import { Product } from '../models/product';
import {CategoryService} from "../services/category.service";
import {Observable} from "rxjs";
import {Category} from "../models/category";
import {Seller} from "../models/seller";
import {SellerService} from "../services/seller.service";
@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(
    private productservice:ProductService,
    private categoryservice:CategoryService,
    private sellerservice:SellerService
  ) { }

  product : Product=new Product();
  submitted = false;
  catigories: Observable<Category[]>;
  selectedcategory?: Category;
  sellers: Observable<Category[]>;
  selectedseller?: Seller;

  ngOnInit() {
    this.submitted=false;

    this.categoryservice.getCategoryList().subscribe(data =>{
      this.catigories =data;
      console.log('catigories');
      console.log(this.catigories);
      this.dtTrigger.next();
    });

    this.sellerservice.getSellerList().subscribe(data =>{
      this.sellers =data;
      console.log('sellers');
      console.log(this.sellers);
      this.dtTrigger.next();
    });

  }

  onSelect(cat: Category): void {
    this.selectedcategory = cat;
  }
  onSelect2(sel: Seller): void {
    this.selectedseller = sel;
  }

  productsaveform=new FormGroup({
    id:new FormControl(),
    name:new FormControl(),
    description:new FormControl(),
    price:new FormControl(),
    image_URL:new FormControl(),
    category:new FormControl(),
    seller:new FormControl(),
  });

  saveProduct(saveProduct){
    this.product=new Product();
    this.product.id=this.ProductId.value;
    this.product.name=this.ProductName.value;
    this.product.description=this.ProductDescription.value;
    this.product.price=this.ProductPrice.value;
    this.product.image_URL=this.ProductImage_URL.value;
    this.product.category=this.ProductCategory.value;
    this.product.seller=this.ProductSeller.value;
    this.submitted = true;
    this.save();
  }

  save() {
    console.log(this.product.category);
    this.productservice.createProduct(this.product)
      .subscribe(data => console.log(data), error => console.log(error));
    this.product = new Product();
  }
  get ProductId(){
    return this.productsaveform.get('id');
  }
  get ProductName(){
    return this.productsaveform.get('name');
  }

  get ProductDescription(){
    return this.productsaveform.get('description');
  }

  get ProductPrice(){
    return this.productsaveform.get('price');
  }

  get ProductImage_URL(){
    return this.productsaveform.get('image_URL');
  }

  get ProductCategory(){
    return this.productsaveform.get('category');
  }

  get ProductSeller(){
    return this.productsaveform.get('seller');
  }

  addSellerForm(){
    this.submitted=false;
    this.productsaveform.reset();
  }
}
