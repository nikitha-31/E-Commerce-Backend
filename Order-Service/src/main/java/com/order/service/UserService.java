package com.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.order.model.UserDto;



@FeignClient(name="USER-SERVICE", url="http://localhost:8000")
public interface UserService {
	
	@GetMapping("/api/user/profile")
	public UserDto getUserProfile(@RequestHeader("Authorization")String jwt);
	

}