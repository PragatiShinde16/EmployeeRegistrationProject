package com.acc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.acc.entity.Employee;

public class GetParticularEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration objConfiguration = new Configuration();
		objConfiguration.configure("hibernate.cfg.xml");
		objConfiguration.addAnnotatedClass(Employee.class);
		
		SessionFactory objSessionFactory = objConfiguration.buildSessionFactory();
		Session session = objSessionFactory.openSession();
		session.beginTransaction();
		
		String hqlQuery = "from Employee where name = :myname and mob_no = :mymob";
		Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
		query.setParameter("myname", "Pradnya");
		query.setParameter("mymob", "9867800800");
		
		Employee employee = query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(employee);
	}

}
