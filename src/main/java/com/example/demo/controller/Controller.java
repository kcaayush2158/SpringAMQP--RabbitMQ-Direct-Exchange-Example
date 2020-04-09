package com.example.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/direct")
public class Controller {
	
	@Autowired
	private AmqpTemplate ampqTemplate;
	
	@GetMapping("/producer")
	public String producer(@RequestParam("exchange") String exchange , @RequestParam("routingKey") String routingKey, @RequestParam("messageData") String messageData)
	{
		ampqTemplate.convertAndSend(exchange,routingKey,messageData);

		return "message send successfully";
	}
	
	

}
