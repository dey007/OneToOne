package org.arka.mvc.dao;

import org.arka.mvc.bean.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int insertAddress(Address add) {
		Session session=sessionFactory.getCurrentSession();
		//add.setEmployee(add.getEmployee());
		session.persist(add);
		return add.getEmpId();
	}

}
