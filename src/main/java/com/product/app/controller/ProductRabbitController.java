package com.product.app.controller;

import com.product.app.producer.ProductRabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductRabbitController {

    //@Autowired
    private ProductRabbitMQProducer productRabbitMQProducer;

    public ProductRabbitController(ProductRabbitMQProducer productRabbitMQProducer){
        this.productRabbitMQProducer = productRabbitMQProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        System.out.println("message value========"+message);
        try {
            productRabbitMQProducer.sendMessage(message);
        }catch (Exception e){
           e.printStackTrace();
        }
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

}
