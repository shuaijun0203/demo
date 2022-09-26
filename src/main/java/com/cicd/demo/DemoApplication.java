package com.cicd.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableBatchProcessing
public class DemoApplication {

	public static void main(String[] args) throws Exception{
		System.out.println("Hello World!");

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("54.248.198.226");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		String exchange_name = "logs";
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(exchange_name, "fanout");
		String message = "hello3";
		channel.basicPublish(exchange_name, "", null, message.getBytes(StandardCharsets.UTF_8));
		System.out.println("send:" + message);

		//SpringApplication.run(DemoApplication.class, args);
		System.exit(SpringApplication.exit(SpringApplication.run(DemoApplication.class, args)));
	}

}
