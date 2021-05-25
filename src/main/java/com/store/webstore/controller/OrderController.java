package com.store.webstore.controller;

import com.store.webstore.model.Order;
import com.store.webstore.service.OrderService;
import com.store.webstore.service.ProductService;
import com.store.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping("/api")
    List<Order> getAll(){
        return orderService.getAllOrder();
    }

    @GetMapping("/api/{orderid}")
    Order getOrder(@PathVariable int orderid){
        Order order = orderService.getOrder(orderid);
        return order;
    }

    @PostMapping("/api")
    Order addOrder(@RequestBody Order order){
//        System.out.println(order);
        return orderService.addOrder(order);

    }

    @DeleteMapping("/api/{orderid}")
    ResponseEntity deleteOrder(@PathVariable int orderid){
        ResponseEntity res;
        try{
            orderService.deleteOrder(orderid);
            res = new ResponseEntity(200, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            res = new ResponseEntity(500, HttpStatus.NOT_FOUND);
        }
        return res;
    }
}
