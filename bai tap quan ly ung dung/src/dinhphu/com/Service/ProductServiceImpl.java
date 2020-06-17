package dinhphu.com.Service;


import dinhphu.com.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl  implements ProductService {
   private static List<Product> products=new ArrayList<>();
    static{
        products.add(new Product("Iphone 7",5226));
        products.add(new Product("Xiao mi",1245));
        products.add(new Product("Redmi",2734));
        products.add(new Product("Bphone",9632));
        products.add(new Product("Samsung",1246));
        products.add(new Product("LG",7454));
        products.add(new Product("BlackBerry",8532));
    }


    @Override
    public void insert(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product newProduct) {
        products.set(id,newProduct);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findProduct(int id) {
        return products.get(id);
    }
    @Override
    public List<Product> findAll(){
        return products;
    }
}
