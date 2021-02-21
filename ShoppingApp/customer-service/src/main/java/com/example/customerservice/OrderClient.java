package com.example.customerservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

 

@FeignClient(name = "order-service", fallback = OrderClientFallback.class)
public interface OrderClient {
    @GetMapping("/")
    Object getOrdersForCustomer(@RequestParam Integer customerId);
    
//    @PostMapping("/")
//    Object saveOrdersForCustomer(@RequestBody Order order);
//    
//    @PostMapping("/all")
//    Object saveAllOrdersForCustomer(@RequestBody List<Order> order);
}	