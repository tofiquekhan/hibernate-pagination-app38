package myproject.pagination.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myproject.pagination.entity.Employee;
import myproject.pagination.util.HibernateUtil;

public class EmployeeService {

	Session session = null;
	Query query = null;
	public EmployeeService() {

	try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		query = session.createQuery("from Employee");
		query.setMaxResults(3);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
	
	public List<Employee> getEmployees(String label){
		List<Employee> empsList = null;
		int count = Integer.parseInt(label);
		try {
			
			query.setFirstResult(3*count);
			empsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return empsList;
	}
}
