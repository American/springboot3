package com.lsh.test.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by houbank on 2019/5/31.
 */
public class SendExchangeTopic {

    private final static String EXCHANGE_NAME = "ex_test01_topic";

    public static void main(String[] args) {



        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME,"topic");

            String message = "Topic。。。。。。。。。" ;
            channel.basicPublish(EXCHANGE_NAME,"routekey.1",null,message.getBytes());
            System.out.println("send message =" + message);

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
