package org.arka.mvc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.arka.mvc.bean.Address;
import org.arka.mvc.bean.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		System.out.println(sessionFactory);
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Employee> findAllByAge(int age) {
		List emp=new ArrayList();
		System.out.println("DAO:"+age);
		//String query="from org.arka.mvc.bean.Employee as e where e.age=:age";
		String query="select e.empId,e.empName,a.hno from org.arka.mvc.bean.Employee as e inner join e.address as a where e.age=:age";
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery(query);
		q.setInteger("age", age);
		@SuppressWarnings("unchecked")
		List<Object[]> list=q.list();
		System.out.println(list.toArray());
		
		Iterator itr=list.iterator();
		while(itr.hasNext()){
			Object obj=itr.next();
			emp.add(obj);
		}
		return emp;
	}

	@Override
	@Transactional
	public int insert(Employee emp) {
		Session session=sessionFactory.getCurrentSession();
		int i=(int) session.save(emp);
		System.out.println(i);
		return i;
	}
}
