package com.store.webstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product",uniqueConstraints = @UniqueConstraint(columnNames = {"product_name"}))
public class Product {
    @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
            @Column(name = "productid")
    int productid;
    @Column(name = "product_name")
    String productName;
    @Column(name = "product_type")
    String productType;
    @Column(name = "price")
    double price;  // indian rupee

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "product_id")
    List<ProductDescription> productDescriptions;


    public List<ProductDescription> getProductDescriptions() {
        return productDescriptions;
    }

    public void setProductDescriptions(List<ProductDescription> productDescriptions) {
        this.productDescriptions = productDescriptions;
    }


    public Product() {
    }

    public Product(int productid, String productName, String productType, double price) {
        this.productid = productid;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
    }

    public int getProductid() {
        return productid;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", price=" + price +
                '}';
    }
}
