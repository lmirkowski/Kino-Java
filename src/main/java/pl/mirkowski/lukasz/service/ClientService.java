package pl.mirkowski.lukasz.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Client;
import pl.mirkowski.lukasz.util.HibernateUtil;


public class ClientService {
	
	public int save(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		int id = (int) session.save(client);
		transaction.commit();
		session.close();
		return id;
	}

}
