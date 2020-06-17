package dinhphu.com.Service;

import dinhphu.com.Model.Product;

import java.util.List;

public interface ProductService {
    void insert(Product product);
    void update(int id,Product newProduct);
    void delete(int id);
    Product findProduct(int id);
    List<Product> findAll();
}
