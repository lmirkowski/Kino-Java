package pl.mirkowski.lukasz.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Repertuar;
import pl.mirkowski.lukasz.util.HibernateUtil;



public class RepertuarService {
	
	public List<Repertuar> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query querry = session.createQuery("SELECT r.title, r.kraj, r.gatunek, r.ogr_wiek FROM Repertuar r");

		@SuppressWarnings("unchecked")
		List<Repertuar> films = querry.list();
		trx.commit();
		session.close();
		return films;
	}
}
