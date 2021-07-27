package com.example.ribbon;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartRestConsumer
{
	// autowire DisocveryClient
	@Autowired
	private DiscoveryClient client;

	public String getCartInfo()
	{
		System.out.println("\n***********************************\n");
		System.out.println("From CartRestConsumer:getCartInfo() - ENTRY");
		System.out.println("\n***********************************\n");

		// get ServiceInstance list using serviceId
		List<ServiceInstance> siList = client.getInstances("server");
		System.out.println("\n***********************************\n");
		System.out.println("From CartRestConsumer: siList: " + siList);
		System.out.println("\n***********************************\n");

		// read manually one instance from index#0 
		ServiceInstance si = siList.get(0);
		System.out.println("\n***********************************\n");
		System.out.println("\n***********************************\n");
		System.out.println("From CartRestConsumer: System Instances: " + si);
		System.out.println("\n***********************************\n");
		System.out.println("\n***********************************\n");

		// read URI and Add path that returns url
		String url = si.getUri() +"/backend";
		System.out.println("\n***********************************\n");
		System.out.println("\n***********************************\n");
		System.out.println("From CartRestConsumer: url: " + url);
		System.out.println("\n***********************************\n");
		System.out.println("\n***********************************\n");

		// create object for RestTemplate
		RestTemplate rt = new RestTemplate();

		// make HTTP call and get Reponse data
		String response = rt.getForObject(url, String.class);

		// return response back to Consumer 
		return response;
	}
}