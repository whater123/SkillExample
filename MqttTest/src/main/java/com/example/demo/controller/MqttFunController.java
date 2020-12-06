package com.example.demo.controller;

import com.example.demo.gateway.TestGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fun")
public class MqttFunController {

	@Autowired
	private TestGateway mqttGateway;

	@RequestMapping("/testMqtt")
	public String sendMqtt(@RequestParam(value = "topic") String topic, @RequestParam(value = "message") String message) {
		mqttGateway.sendToMqtt(message, topic);
		return "SUCCESS";
	}
}
