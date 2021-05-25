package com.store.webstore.controller;

import com.store.webstore.model.Product;
import com.store.webstore.model.ProductDescription;
import com.store.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/api")
    public List<Product> getProduct(){
        return productService.getAllProducts();
    }
    @GetMapping("/api/p/{productName}")
    public Product getProductByName(@PathVariable String productName){
        return productService.getProductByName(productName);
    }

    @GetMapping("/api/t/{productType}")
    public List<Product> getProductByType(@PathVariable String productType){
        return productService.getProductsByType(productType);
    }

    @GetMapping("/api/price/{price}")
    public List<Product> getProductByPrice(@PathVariable double price){
        return productService.getProductsBelowPrice(price);
    }

    @GetMapping("/api/q/{productName}")
    public List<Product> getProductByStartWith(@PathVariable String productName){
        return productService.getProductsStartWith(productName);
    }

    @PostMapping("/api")
    public Product addProduct(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/api")
    public Product updateProduct(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/api/name/{productName}")
    public Product deleteProduct(@PathVariable String productName){
        return productService.delete(productName);
    }

    @DeleteMapping("/api/{productId}")
    public ResponseEntity deleteProductById(@PathVariable int productId){
        try {
            productService.deleteById(productId);
            return new ResponseEntity(HttpStatus.valueOf(200));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/{productId}/desp")
    public List<ProductDescription> getAllDesp(@PathVariable int productId){
        return productService.getAllProductDescription(productId);
    }

    @PostMapping("/api/{productId}/desp")
    public ResponseEntity addDesp(@PathVariable int productId,@RequestBody ProductDescription productDescription){
        ResponseEntity resp;
        try {
            productService.addDescription(productId, productDescription);
            resp = new ResponseEntity(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp = new ResponseEntity(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return resp;
    }

//    @DeleteMapping("/api/{productId}/desp/{id}")
//    public ResponseEntity deleteR

}
