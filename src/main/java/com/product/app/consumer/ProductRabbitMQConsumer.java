package com.product.app.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductRabbitMQConsumer {

   // private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductRabbitMQProducer.class);

    //@RabbitListener(queues = {"${rabbitmq.queue.name}"})
    @RabbitListener(queues = "product_queue")
    public void consume(String message){
        System.out.println("message in consumer============="+message);
    }


}
