package pl.mirkowski.lukasz.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Seans;
import pl.mirkowski.lukasz.util.HibernateUtil;

public class SummaryService {

	

	public List<Seans> chosenSeans(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM Seans WHERE id=:id");

		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Seans> selectedSeanses = query.list();

		trx.commit();
		session.close();

		return selectedSeanses;
	}

}
