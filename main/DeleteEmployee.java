package com.acc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.acc.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration objConfiguration = new Configuration();
		objConfiguration.configure("hibernate.cfg.xml");
		objConfiguration.addAnnotatedClass(Employee.class);
		
		SessionFactory objFactory = objConfiguration.buildSessionFactory();
		Session session = objFactory.openSession();
		session.beginTransaction();
		
		String query = "Delete Employee where name =: myname";
		MutationQuery objMutationQuery = session.createMutationQuery(query);
		objMutationQuery.setParameter("myname", "Pragati");
		int status = objMutationQuery.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
		if (status > 0) {
			System.out.println("Deleted");
		}else {
			System.out.println("Not Deleted");
		}
	}

}
