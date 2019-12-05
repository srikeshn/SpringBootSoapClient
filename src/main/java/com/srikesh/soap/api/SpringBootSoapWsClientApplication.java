package com.srikesh.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srikesh.soap.api.client.SoapClient;
import com.srikesh.soap.client.wsdl.Add;
import com.srikesh.soap.client.wsdl.AddResponse;

@SpringBootApplication
@RestController
public class SpringBootSoapWsClientApplication {
	
	@Autowired
	private SoapClient client;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapWsClientApplication.class, args);
	}

	
	@PostMapping("/add")
	public int add(@RequestBody Request req)
	{
		Add a = new Add();
		a.setIntA(req.getA());
		a.setIntB(req.getB());
		return client.add(a).getAddResult();
	}
}
