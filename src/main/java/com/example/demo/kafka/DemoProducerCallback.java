package com.example.demo.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

import javax.swing.plaf.SpinnerUI;

/**
 * @Author: Xiao
 * @Date: 2019/9/10 :19:47
 * @Description:
 */
public class DemoProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (exception != null) {
            exception.printStackTrace();
        }
        System.out.println("偏移量："+metadata.offset());
        System.out.println("消息分区:"+metadata.partition());
    }
}
