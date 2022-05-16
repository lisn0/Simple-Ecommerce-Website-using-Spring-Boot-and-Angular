import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SellerListComponent } from './seller-list/seller-list.component';
import { AddSellerComponent } from './add-seller/add-seller.component';
import { ProductListComponent } from './product-list/product-list.component';
import { AddProductComponent } from './add-product/add-product.component';
import {CategoryListComponent} from './category-list/category-list.component';
import {AddCategoryComponent} from './add-category/add-category.component';

const routes: Routes = [
  { path: '', redirectTo: 'view-sellers', pathMatch: 'full' },
  { path: 'view-sellers', component: SellerListComponent },
  { path: 'view-category', component: CategoryListComponent },
  { path: 'add-seller', component: AddSellerComponent },
  { path: 'view-products', component: ProductListComponent },
  { path: 'add-product', component: AddProductComponent },
  { path: 'add-category', component: AddCategoryComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
