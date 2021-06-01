package com.test.demo.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ProducerTest.java
 * @包 路 径： com.test.demo.kafka.producer
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/5/28 16:40
 */
public class ProducerTest {
    static Logger log = LoggerFactory.getLogger(ProducerTest.class);

    private static final String TOPIC = "milo2";
    private static final String BROKER_LIST = "118.212.149.51:9092";
    private static KafkaProducer<String, String> producer = null;

    /*
    初始化生产者
     */
    static {
        Properties configs = initConfig();
        producer = new KafkaProducer<String, String>(configs);
    }

    /*
    初始化配置
     */
    private static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    public static void main(String[] args) throws InterruptedException {
        //消息实体
        ProducerRecord<String, String> record = null;
        for (int i = 0; i < 1000; i++) {
            record = new ProducerRecord<String, String>(TOPIC, "value" + (int) (10 * (Math.random())));
            //发送消息
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (null != e) {
                        log.info("send error" + e.getMessage());
                    } else {
                        System.out.println(String.format("offset:%s,partition:%s", recordMetadata.offset(), recordMetadata.partition()));
                    }
                }
            });
        }
        producer.close();
    }
}
