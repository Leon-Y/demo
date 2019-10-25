package com.example.demo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;
import org.apache.kafka.common.serialization.StringSerializer;
/**
 * @Author: Xiao
 * @Date: 2019/9/10 :15:27
 * @Description:
 */
public class KafkaSender {
    private Properties kafkaProp = new Properties();
    public KafkaSender(){
        this.kafkaProp.put("bootstrap.servers","23.105.210.91:9092");
        this.kafkaProp.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        this.kafkaProp.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
    }
    public KafkaProducer<String,String> getKafkaProducer(){
        return new KafkaProducer(kafkaProp);
    }
}
