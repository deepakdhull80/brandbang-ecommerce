package com.store.webstore.service;

import com.store.webstore.dao.OrderRepository;
import com.store.webstore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @Override
    public Order getOrder(int orderid) {
        Order order = orderRepository.findById(orderid).get();
        order.setUser(userService.getUserById(order.getUserid()));
        order.setProduct(productService.getProductById(order.getProductid()));
        return order;
    }

    @Override
    public Order addOrder(Order order) {
//        System.out.println(order);
        order.setDateOfCreation(new Date());
//        order.setUser(userService.getUserByUserName(order.getUser().getUserName()));
//        order.setProduct(productService.getProductByName(order.getProduct().getProductName()));
        order = orderRepository.save(order);
        order.setUser(userService.getUserById(order.getUserid()));
        order.setProduct(productService.getProductById(order.getProductid()));
        return order;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order > res = orderRepository.findAll();
        res.stream().forEach(order->{
            order.setUser(userService.getUserById(order.getUserid()));
            order.setProduct(productService.getProductById(order.getProductid()));
        });
        return res;
    }

    @Override
    public void deleteOrder(int orderid) {
        orderRepository.deleteById(orderid);
    }
}
