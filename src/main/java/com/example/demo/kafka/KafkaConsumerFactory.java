package com.example.demo.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

/**
 * @Author: Xiao
 * @Date: 2019/9/16 :11:13
 * @Description:
 */
public class KafkaConsumerFactory {
    private Properties properties;
    private KafkaConsumerFactory(Properties properties){
        this.properties = properties;
    }
    public static KafkaConsumer getConsumer(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers","172.16.9.35:9092");
        properties.put("group.id","my-topic");
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        return new KafkaConsumer(properties);
    }
}
