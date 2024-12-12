package com.product.app.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.product.app.event.ProductEvent;
import com.product.app.event.ProductEventType;
import com.product.app.producer.ProductKafkaEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class ProductKafkaController {

    @Autowired
    ProductKafkaEventProducer productKafkaEventProducer;

    @PostMapping("/productEvent")
    public ResponseEntity<ProductEvent> postProductEvent(@RequestBody ProductEvent productEvent) throws JsonProcessingException, ExecutionException, InterruptedException {
        //productEvent.setProductEventType(ProductEventType.NEW);
        productKafkaEventProducer.sendProducerEvents_Approach3(productEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(productEvent);
    }

}
