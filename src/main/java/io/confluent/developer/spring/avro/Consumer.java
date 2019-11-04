package io.confluent.developer.spring.avro;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import dbserver1.shopping.product.User;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

  @Value("${topic.name}")
  private String topicName;
  

  @KafkaListener(topics = "dbserver1.shopping.product", groupId = "groupid")
  public void consume(ConsumerRecord<String, User> record) {
	  System.out.printf(String.format("Consumed message -> %s\n", record.value()));
  }
}