package pl.mirkowski.lukasz.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Klient;
import pl.mirkowski.lukasz.util.HibernateUtil;


public class KlientService {
	
	public int save(Klient klient) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		int idklient = (int) session.save(klient);
		transaction.commit();
		session.close();
		return idklient;
	}

}
