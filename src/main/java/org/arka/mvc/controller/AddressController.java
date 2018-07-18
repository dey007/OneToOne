package org.arka.mvc.controller;

import org.arka.mvc.bean.Address;
import org.arka.mvc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	public int insertAddress(@RequestBody Address add){
		return addressService.insertAddress(add);
	}

}
