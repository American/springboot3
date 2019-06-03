package com.lsh.test.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * Created by houbank on 2019/5/31.
 */
public class Send {

    private final static String QUEUE_NAME = "q_test01";

    public static void main(String[] args) {



        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            for(int i=0;i<20;i++){
                String message = "get a good work! lishouhong%" + i;
                channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

                System.out.println("send message =" + message);
                Thread.sleep(10);
            }

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
