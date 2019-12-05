package com.srikesh.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.srikesh.soap.client.wsdl.Add;
import com.srikesh.soap.client.wsdl.AddResponse;

@Component
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public AddResponse add(Add request) {
		template = new WebServiceTemplate(marshaller);
		AddResponse res = (AddResponse) template.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,
				new SoapActionCallback(
		                "http://tempuri.org/Add"));
		return res;
	}
	
}
