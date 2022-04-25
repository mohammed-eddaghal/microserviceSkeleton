package com.giantlink.companyService.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//reactualise les valeurs de @Value vient de configuration file
@RestController
@RefreshScope
@RequestMapping("companies")
public class companyController {

	@Value("${xParam}")
	private int xParam;
	@Value("${yParam}")
	private int yParam;
	@Value("${me}")
	private String me;
	
	
	@GetMapping("/myConfig")
	public Map<String, Object> myConfig(){
		Map<String, Object> map= new HashMap<>();
		map.put("xparam", xParam);
		map.put("yparam", yParam);
		map.put("me", me);
		map.put("threadName", Thread.currentThread().getName());
		
		return map;
		
	}
}
