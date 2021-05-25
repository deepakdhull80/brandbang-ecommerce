package com.store.webstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDescription {
    @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String productDesciption;
//    int productId;
    public ProductDescription() {
    }

    public ProductDescription(String productDesciption) {
        this.productDesciption = productDesciption;
    }

    public int getId() {
        return id;
    }

    public String getProductDesciption() {
        return productDesciption;
    }
}
