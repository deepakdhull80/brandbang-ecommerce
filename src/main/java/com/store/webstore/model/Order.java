package com.store.webstore.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int orderid;
    int userid;
    int productid;
    @ColumnDefault(value = "1")
    int quantity;
    Date dateOfCreation;

    @Transient
    User user;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Transient
    Product product;

    public Order() {
    }

    public Order(int orderid, int userid, int productid, int quantity, Date dateOfCreation) {
        this.orderid = orderid;
        this.userid = userid;
        this.productid = productid;
        this.quantity = quantity;
        this.dateOfCreation = dateOfCreation;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
