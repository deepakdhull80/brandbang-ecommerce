package com.store.webstore.service;

import com.store.webstore.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order getOrder(int orderid);

    Order addOrder(Order order);

    List<Order> getAllOrder();

    void deleteOrder(int orderid);
}
