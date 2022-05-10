import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {DataTablesModule} from 'angular-datatables';
import { SellerListComponent } from './seller-list/seller-list.component';
import { SellerService } from './services/seller.service';
import { AddSellerComponent } from './add-seller/add-seller.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductService } from './services/product.service';
import { AddProductComponent } from './add-product/add-product.component';
import {CategoryListComponent} from './category-list/category-list.component';
import {CategoryService} from './services/category.service';

@NgModule({
  declarations: [
    AppComponent,
    SellerListComponent,
    AddSellerComponent,
    ProductListComponent,
    AddProductComponent,
    CategoryListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataTablesModule
  ],
  providers: [SellerService, ProductService, CategoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
