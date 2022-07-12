package com.nagarro.tshirt.availability.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.tshirt.availability.model.TShirt;

public class HibernateConnector {
	public static SessionFactory sessionFactory;

	public static SessionFactory hibernateSession() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(TShirt.class);
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
