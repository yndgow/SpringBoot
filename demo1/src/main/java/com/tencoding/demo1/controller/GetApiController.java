package com.tencoding.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetApiController {

	// 주소 설계
	// /api/hello
	// localhost:8080/api/hello	
	@GetMapping("/api/hello")
	public String getHello() {
		return "Say Hello";
	}
	
	// localhost:8080/api?name="a"&age="10"
	@GetMapping("api")
	public String queryParam1(@RequestParam String name, @RequestParam int age) {
		return "name : " + name + ", age : " + age;
	}
	
	// http://localhost:8080/api/query-param3?name=홍길동
	@GetMapping("api/{query}")
	public String test3(@PathVariable String query, String name) {
		return "query : " + query + ", name : " + name;
	}
	
}
