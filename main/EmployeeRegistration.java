package com.acc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acc.entity.Employee;

public class EmployeeRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration objConfiguration = new Configuration();
		objConfiguration.configure("hibernate.cfg.xml");
		objConfiguration.addAnnotatedClass(Employee.class);
		
		SessionFactory objSessionFactory = objConfiguration.buildSessionFactory();
		
		Session session = objSessionFactory.openSession();
		
		Employee emp = new Employee();
		emp.setName("Sarthak");
		emp.setSalary(48000.00);
		emp.setRole("Tester");
		emp.setMob_no("9856542300");
		
		
		session.beginTransaction();
		session.persist(emp);
		session.getTransaction().commit();
		session.close();
	}

}
