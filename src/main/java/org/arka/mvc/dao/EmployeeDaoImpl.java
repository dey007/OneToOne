package org.arka.mvc.dao;

import java.util.List;

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
		System.out.println("DAO:"+age);
		String query="from org.arka.mvc.bean.Employee as e where e.age=:age";
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery(query);
		q.setInteger("age", age);
		@SuppressWarnings("unchecked")
		List<Employee> list=q.list();
		System.out.println(list.toArray());
		return list;
	}

	@Override
	@Transactional
	public int insert(Employee emp) {
		Session session=sessionFactory.getCurrentSession();
		//System.out.println(emp.getAge()+" "+emp.getEmpId()+" "+emp.getEmpName());
		session.persist(emp);
		//System.out.println(emp.getAge()+" "+emp.getEmpId()+" "+emp.getEmpName());
		return emp.getEmpId();
	}
}
