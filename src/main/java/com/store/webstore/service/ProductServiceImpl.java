package com.store.webstore.service;

import com.store.webstore.dao.ProductDescriptionRepository;
import com.store.webstore.dao.ProductRepository;
import com.store.webstore.model.Product;
import com.store.webstore.model.ProductDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDescriptionRepository productDescriptionRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public List<Product> getProductsStartWith(String startingString) {
        return productRepository.findByNameAndStartWith(startingString);
    }

    @Override
    public List<Product> getProductsByType(String type) {
        return  productRepository.findByType(type);
    }

    @Override
    public List<Product> getProductsBelowPrice(double basePrice) {
        return productRepository.findByPrice(basePrice);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product delete(String productName) {
        Product p = this.getProductByName(productName);
        if(p==null){
            throw new UsernameNotFoundException(productName+" not found");
        }
        productRepository.delete(p);
        return p;
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductDescription> getAllProductDescription(int productId) {
        return productDescriptionRepository.findAllByProductId(productId);
    }

    @Override
    public void addDescription(int productId, ProductDescription productDescription) {
        int nextId = this.getAllProductDescription(productId).stream().max(new Comparator<ProductDescription>() {
            @Override
            public int compare(ProductDescription o1, ProductDescription o2) {
                return o1.getId()- o2.getId();
            }
        }).get().getId();

        productDescriptionRepository.addDesc(nextId+1,productId,productDescription.getProductDesciption());
    }

    @Override
    public void deleteById(int productId) {
        productRepository.deleteById(productId);
    }
}
