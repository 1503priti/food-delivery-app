package com.elisha.order.controller;

import com.elisha.order.dto.OrderDTO;
import com.elisha.order.dto.OrderDTOFromFE;
import com.elisha.order.service.OrderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO orderSavedInDB=  orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDB,HttpStatus.CREATED);

    }
}
