package com.lsh.test.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by houbank on 2019/5/31.
 */
public class SendExchange {

    private final static String EXCHANGE_NAME = "ex_test01_fanout";

    public static void main(String[] args) {



        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();

            //channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
            //for(int i=0;i<20;i++){
            String message = "get a good work! lishouhong%" ;
            channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());

            System.out.println("send message =" + message);
            //Thread.sleep(10);
            //}

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
