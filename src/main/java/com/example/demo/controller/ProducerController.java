package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.array.GeneratorProducer;
import com.example.demo.kafka.DemoProducerCallback;
import com.example.demo.kafka.KafkaConsumerFactory;
import com.example.demo.kafka.KafkaSender;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequestMapping(value = "/kafka")
@Controller
public class ProducerController {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/producer",method = RequestMethod.GET)
    public @ResponseBody String consume(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        String value = "{\"code\":200,\"dataVersion\":\"17q1\",\"message\":\"\",\"id\":\"364f79f28eea48eefeca8c85477a10d3\",\"source\":\"didi\",\"tripList\":[{\"subTripList\":[{\"startTimeStamp\":1519879598,\"schemeList\":[{\"distance\":0.0,\"ids\":\"94666702,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519879598,\"subTripId\":0},{\"startTimeStamp\":1519879727,\"schemeList\":[{\"distance\":1395.0,\"ids\":\"94666729,7298838,7291709,7291706,88613298,88613297,7297542,7297541,94698785,94698786,94698778,94698780,94698779,94698782,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519879812,\"subTripId\":1},{\"startTimeStamp\":1519879836,\"schemeList\":[{\"distance\":0.0,\"ids\":\"54123007,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519879904,\"subTripId\":2},{\"startTimeStamp\":1519879959,\"schemeList\":[{\"distance\":0.0,\"ids\":\"54190443,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519879959,\"subTripId\":3},{\"startTimeStamp\":1519880088,\"schemeList\":[{\"distance\":2885.0,\"ids\":\"94698824,94698822,94698789,94698786,54123011,54123012,54123002,94698763,94698727,94698722,94698765,54123006,54123004,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519880300,\"subTripId\":4},{\"startTimeStamp\":1519880393,\"schemeList\":[{\"distance\":2398.0,\"ids\":\"7309441,7303680,54123061,54123038,7309478,7309477,94698204,94698203,94698273,94698274,94698288,94698296,94698295,94698289,94698310,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519880636,\"subTripId\":5},{\"startTimeStamp\":1519881064,\"schemeList\":[{\"distance\":35.0,\"ids\":\"7309474,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519881204,\"subTripId\":6},{\"startTimeStamp\":1519881204,\"schemeList\":[{\"distance\":28.0,\"ids\":\"7309476,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519881266,\"subTripId\":7},{\"startTimeStamp\":1519881291,\"schemeList\":[{\"distance\":463.0,\"ids\":\"7303683,\",\"schemeId\":0,\"linkList\":[{\"score\":72,\"distance\":1,\"gpsList\":[{\"origLonLat\":\"116.321343,40.43242\",\"grabLonLat\":\"112.32312,40.32132\",\"timestamp\":1515149926000}]}]}],\"endTimeStamp\":1519881329,\"subTripId\":8}],\"startTimeStamp\":1519879350,\"unUseTime\":1201,\"totalTime\":2049,\"endTimeStamp\":1519881399,\"tripId\":0}]}";
        int value = 0;
        long start = System.currentTimeMillis();
        GeneratorProducer.stringGenerator stringGenerator = new GeneratorProducer.stringGenerator(1000);
        for (int i = 1; i<=500000; i++){
            ListenableFuture test = kafkaTemplate.send("test", String.valueOf(stringGenerator.next()));
            value++;
        }
        long end = System.currentTimeMillis()-start;
        kafkaTemplate.send("test", String.valueOf(end));
        System.out.println(end/1000);
        return String.valueOf(end);
    }

    @RequestMapping(value = "/kafkaSender",method = RequestMethod.GET)
    public @ResponseBody String testKafkaSender(String message){
        KafkaSender kafkaSender = new KafkaSender();
        KafkaProducer<String, String> kafkaProducer = kafkaSender.getKafkaProducer();
        ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<>("my-topic", "say", message);
        Future<RecordMetadata> send = kafkaProducer.send(stringStringProducerRecord,new DemoProducerCallback());
        try {
            return JSONObject.toJSONString(send.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "失败的回调";
    }

    public static void main(String[] args) {
        KafkaConsumer consumer = KafkaConsumerFactory.getConsumer();
        consumer.subscribe(Collections.singletonList("DATA_CENTER_REPORT_DZB_HUMAN_PROJECT_NUM"));
        while (true){
            ConsumerRecords poll = consumer.poll(Duration.of(10000, ChronoUnit.MILLIS));
            Iterator iterator = poll.iterator();
            while (iterator.hasNext()){
                Object next = iterator.next();
                System.out.println(next);
            }

        }
    }
}