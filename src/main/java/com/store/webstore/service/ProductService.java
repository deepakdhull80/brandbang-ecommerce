package com.store.webstore.service;

import com.store.webstore.model.Product;
import com.store.webstore.model.ProductDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public Product getProductByName(String productName);
    public List<Product> getProductsStartWith(String startingString);
    public List<Product> getProductsByType(String type);
    public List<Product> getProductsBelowPrice(double basePrice);

    public Product update(Product product);
    public Product delete(String productName);

    public Product add(Product product);

    public List<ProductDescription> getAllProductDescription(int productId);

    void addDescription(int productId, ProductDescription productDescription);

    void deleteById(int productId);
}
