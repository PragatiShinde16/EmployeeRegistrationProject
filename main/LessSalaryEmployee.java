package com.acc.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.acc.entity.Employee;

public class LessSalaryEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration objConfiguration = new Configuration();
		objConfiguration.configure("hibernate.cfg.xml");
		objConfiguration.addAnnotatedClass(Employee.class);
		
		SessionFactory objSessionFactory = objConfiguration.buildSessionFactory();
		Session session = objSessionFactory.openSession();
		session.beginTransaction();
		
		String hqlQuery = "from Employee where salary <:mysalary";
		Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
		query.setParameter("mysalary", 50000.00);
		
		List<Employee> empList = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for (Employee emp : empList) {
			System.out.println(emp);
		}
		
		
	}

}
