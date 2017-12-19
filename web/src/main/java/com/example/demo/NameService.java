package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ryan Baxter
 */
@Service
public class NameService {
	private static final String URL = "http://locahost:8002";
	private RestTemplate rest;


	public NameService(RestTemplate rest) {
		this.rest = rest;
	}

	public String getName() {
		return rest.getForObject(URL, String.class);	}

	@FeignClient("name")
	static interface NameFeignClient {
		@RequestMapping("/")
		public String getName();
	}
}
