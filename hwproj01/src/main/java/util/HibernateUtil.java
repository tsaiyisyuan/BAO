package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibernateUtil {
	private static final SessionFactory sessionfactory=createSessionFactory();

	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory =new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		return factory;
	}

	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	
	public static void closeSessionFactory() {
		if(sessionfactory!=null) {
			sessionfactory.close();
		}
	}
	
	
}
