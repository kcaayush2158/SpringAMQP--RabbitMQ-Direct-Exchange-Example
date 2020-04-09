package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
     Queue myQueue() {
       return new Queue("myQueue",false);
    }
    
    @Bean 
    Queue financeQueue() {
    	return new Queue("financeQueue",false);
    }
    
    @Bean
    Queue adminQueue() {
    	return new Queue("adminQueue,",false);
    }
    
    @Bean
    DirectExchange directExchange() {
    	return new DirectExchange("direct-exchange");
    }
    
    @Bean
    Binding financeBinding(Queue financeQueue,DirectExchange exchange) {
    	return BindingBuilder.bind(financeQueue).to(exchange).with("finance");
    }
    
    @Bean
    Binding adminBinding(Queue adminQueue,DirectExchange exchange) {
    	return BindingBuilder.bind(adminQueue).to(exchange).with("admin");
    }
    
    
}
