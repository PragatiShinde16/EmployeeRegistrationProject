package com.acc.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.acc.entity.Employee;

public class DeveloperEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration objConfiguration = new Configuration();
		objConfiguration.configure("hibernate.cfg.xml");
		objConfiguration.addAnnotatedClass(Employee.class);
		
		SessionFactory objFactory = objConfiguration.buildSessionFactory();
		Session session = objFactory.openSession();
		session.beginTransaction();
		
		String hqlQuery = "from Employee where role =:myrole";
		
		Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
		query.setParameter("myrole", "developer");
		
		List<Employee> list = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}

	}

}
