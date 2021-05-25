package com.store.webstore.dao;

import com.store.webstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select p from Product p where p.productName= ?1")
    public Product findByName(String productName);

    @Query(value = "select p from Product p where p.productName like %?1%")
    List<Product> findByNameAndStartWith(String startingString);

    @Query(value = "select p from Product p where p.productType = ?1")
    List<Product> findByType(String type);

    @Query(value = "select p from Product p where p.price<=?1")
    List<Product> findByPrice(double basePrice);



}
