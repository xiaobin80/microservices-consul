package com.tdtc.consul.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "userdetails")
public interface IUserDetails {
	 @RequestMapping(path = "/user/listPage", method = RequestMethod.GET)
     String findAll();
}
