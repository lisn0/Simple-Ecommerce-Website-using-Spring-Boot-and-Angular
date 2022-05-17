import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../services/category.service';
import { Category } from '../models/category';
import { Observable,Subject } from "rxjs";

import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

 constructor(private categoryservice:CategoryService) { }

  categoryArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();


  categorys: Observable<Category[]>;
  category: Category=new Category();
  updCategory: Category=new Category();
  deleteMessage=false;
  categorieslist:any;
  isupdated = false;


  ngOnInit() {
    this.isupdated=false;
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };
    this.categoryservice.getCategoryList().subscribe(data =>{
    this.categorys =data;
    this.dtTrigger.next();
    })
  }
  deleteCategory(id: string) {
    this.categoryservice.deleteCategory(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.categoryservice.getCategoryList().subscribe(data =>{
            this.categorys =data
            })
        },
        error => console.log(error));
  }


  updateCategory(id: string){
    this.categoryservice.getCategory(id)
      .subscribe(
        data => {
          this.categorieslist=data
        },
        error => console.log(error));
  }

  showCategory(category: Category){
    this.updCategory = category;
    console.log(this.isupdated);
  }


  categoryupdateform=new FormGroup({
    id:new FormControl(),
    name:new FormControl(),
  });

  updateCat(updcat){
    this.category=new Category();
    this.category.id=this.CategoryId.value;
    this.category.name=this.CategoryName.value;
    console.log(this.CategoryId.value);


   this.categoryservice.updateCategory(this.category.id,this.category).subscribe(
    data => {
      this.isupdated=true;
      this.categoryservice.getCategoryList().subscribe(data =>{
        this.categorys =data
        })
    },
    error => console.log(error));
  }

  get CategoryName(){
    return this.categoryupdateform.get('name');
  }
  get CategoryId(){
    return this.categoryupdateform.get('id');
  }


  changeisUpdate(){
    this.isupdated=false;
  }
}
