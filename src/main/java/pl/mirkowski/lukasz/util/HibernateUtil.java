package pl.mirkowski.lukasz.util;

import java.util.Objects;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		
		if(Objects.isNull(sessionFactory)) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}

}
