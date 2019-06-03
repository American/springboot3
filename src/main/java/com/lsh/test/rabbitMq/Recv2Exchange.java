package com.lsh.test.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Created by houbank on 2019/5/31.
 */
public class Recv2Exchange {

    private final static String EXCHANGE_NAME = "ex_test01_fanout";

    private final static String QUEUE_NAME = "queue_test02";
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
            channel.basicQos(1);
            QueueingConsumer customer = new QueueingConsumer(channel);

            channel.basicConsume(QUEUE_NAME,false,customer);

            while (true){
                QueueingConsumer.Delivery delivery = customer.nextDelivery();
                String msg = new String(delivery.getBody());
                Thread.sleep(10);
                System.out.println("11111111111get a msg="+msg);
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
