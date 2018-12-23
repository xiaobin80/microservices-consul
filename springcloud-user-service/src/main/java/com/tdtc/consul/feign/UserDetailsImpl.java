package com.tdtc.consul.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import com.tdtc.consul.service.IUserDetails;

@Configuration
@EnableFeignClients
public class UserDetailsImpl implements IUserDetails {

	@Autowired
	IUserDetails userDetails;
	
	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return userDetails.findAll();
	}

}
