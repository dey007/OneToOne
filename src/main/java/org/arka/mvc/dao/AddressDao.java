package org.arka.mvc.dao;

import org.arka.mvc.bean.Address;
import org.springframework.stereotype.Repository;

public interface AddressDao {
	public int insertAddress(Address add);
}
