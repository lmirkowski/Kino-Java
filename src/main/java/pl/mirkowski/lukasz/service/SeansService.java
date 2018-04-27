package pl.mirkowski.lukasz.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Film;
import pl.mirkowski.lukasz.model.Seans;
import pl.mirkowski.lukasz.util.HibernateUtil;

public class SeansService {
	public List<Seans> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query querry = session.createQuery("SELECT s FROM Seans s");

		@SuppressWarnings("unchecked")
		List<Seans> seans = querry.list();
		trx.commit();
		session.close();
		return seans;
	}

	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query querry = session.createQuery("DELETE FROM Seans WHERE id=:id");
		querry.setLong("id", id);
		querry.executeUpdate();

		trx.commit();
		session.close();

	}

	public int save(Seans seans) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		int id = (int) session.save(seans);
		transaction.commit();
		session.close();
		return id;
	}

}
