package pl.mirkowski.lukasz.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Film;
import pl.mirkowski.lukasz.util.HibernateUtil;


public class FilmService {
	public List<Film> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query querry = session.createQuery("SELECT f.title, f.kraj, f.gatunek, f.ogr_wiek FROM Film f");

		@SuppressWarnings("unchecked")
		List<Film> films = querry.list();
		trx.commit();
		session.close();
		return films;
	}
}
