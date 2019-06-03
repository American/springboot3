package com.lsh.test.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by houbank on 2019/5/31.
 */
public class SendExchangeDirect {

    private final static String EXCHANGE_NAME = "ex_test01_direct";

    public static void main(String[] args) {



        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME,"direct");

            String message = "添加。。。。。。。。。" ;
            //channel.basicPublish(EXCHANGE_NAME,"delete",null,message.getBytes());
            channel.basicPublish(EXCHANGE_NAME,"add",null,message.getBytes());
            System.out.println("send message =" + message);

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
