package com.lsh.test.rabbitMq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by houbank on 2019/5/31.
 */
public class ConnectionUtil {

    public static Connection getConnection() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("10.150.20.91");
        factory.setPort(5672);
        factory.setVirtualHost("lshHost");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        return connection;
    }
}
