package com.acc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.acc.entity.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration objConfiguration = new Configuration();
		objConfiguration.configure("hibernate.cfg.xml");
		objConfiguration.addAnnotatedClass(Employee.class);
		
		SessionFactory objSessionFactory = objConfiguration.buildSessionFactory();
		Session session = objSessionFactory.openSession();
		session.beginTransaction();
		
		String query = "Update Employee set salary = : mysalary where name = : myname";
		
		MutationQuery objMutationQuery = session.createMutationQuery(query);
		objMutationQuery.setParameter("mysalary", 92000.00);
		objMutationQuery.setParameter("myname", "Rohit");
		
		int status = objMutationQuery.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
		if (status > 0) {
			System.out.println("Updated Sucessfully");
		}else {
			System.out.println("Not Updated Sucessfully");
		}
	}

}
