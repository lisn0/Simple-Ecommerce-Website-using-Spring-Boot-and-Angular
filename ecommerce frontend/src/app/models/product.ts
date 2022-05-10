import { Category } from './category';
import { Seller } from './seller';


export class Product{
    id: string;
	name: string;
	description: string;
	price: number;
	image_URL: string;
	category: Category;
	seller: Seller;
  constructor(){

  }

}
