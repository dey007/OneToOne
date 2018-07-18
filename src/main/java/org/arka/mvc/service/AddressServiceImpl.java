package org.arka.mvc.service;

import org.arka.mvc.bean.Address;
import org.arka.mvc.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
	
	public int insertAddress(Address add) {
		return addressDao.insertAddress(add);
	}

}
