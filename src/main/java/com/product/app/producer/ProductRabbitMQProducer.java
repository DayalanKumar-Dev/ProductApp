package com.product.app.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Service;



@Service

public class ProductRabbitMQProducer {

  //  private Logger logger = LoggerFactory.getLogger(ProductRabbitMQProducer.class);

   /* @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;*/

    private RabbitTemplate rabbitTemplate;

    public ProductRabbitMQProducer(RabbitTemplate rabbitTemplate){
       this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        System.out.println("message from producer===="+message);
        try {
            rabbitTemplate.convertAndSend("product_exchange", "product_routing_key", message);
        }catch (Exception e){
            System.out.println("=================");
            e.printStackTrace();
            System.out.println("*****************");
        }

    }

}
