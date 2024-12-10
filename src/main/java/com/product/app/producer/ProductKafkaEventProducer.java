package com.product.app.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.app.event.ProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class ProductKafkaEventProducer {

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    String topic = "producer-events";

    @Autowired
    ObjectMapper objectMapper;

    //below method used for asynchronous approach
    public void sendProducerEvents(ProductEvent productEvent) throws JsonProcessingException {
        Integer key = productEvent.getProductEventId();
        String value = objectMapper.writeValueAsString(productEvent);

        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.sendDefault(key, value);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key,value, ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, value, result);
            }
        });
    }

    public void sendProducerEvents_Approach3(ProductEvent productEvent) throws JsonProcessingException{
        try{
            Integer key = productEvent.getProductEventId();
            String value = objectMapper.writeValueAsString(productEvent);
            ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, topic);
            log.info("sending message in approach3========start");
            kafkaTemplate.send(producerRecord);
            log.info("sending message in approach3========end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic){
        return new ProducerRecord<>(topic, null, key, value, null);
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer,String> result){
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
    }

    private void handleFailure(Integer key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }

}
