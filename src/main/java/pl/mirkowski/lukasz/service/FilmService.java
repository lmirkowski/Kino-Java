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
		Query querry = session.createQuery("SELECT f FROM Film f");

		@SuppressWarnings("unchecked")
		List<Film> films = querry.list();
		trx.commit();
		session.close();
		return films;
	}

	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query querry = session.createQuery("DELETE FROM Film WHERE id=:id");
		querry.setLong("id", id);
		querry.executeUpdate();

		trx.commit();
		session.close();

	}

	public int save(Film film) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		int id = (int) session.save(film);
		transaction.commit();
		session.close();
		return id;
	}
	
	public void update(Film selectedItem) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(selectedItem);
		transaction.commit();
		session.close();
	}
}
