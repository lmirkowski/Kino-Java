package pl.mirkowski.lukasz.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Reservation;
import pl.mirkowski.lukasz.model.Rezerwacje;
import pl.mirkowski.lukasz.util.HibernateUtil;

public class ReservationService {
	
	public List<Reservation> getAll(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query querry = session.createQuery("SELECT r FROM Reservation r");

		@SuppressWarnings("unchecked")
		List<Reservation> reservations = querry.list();
		trx.commit();
		session.close();
		return reservations;
	}
	
	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query querry = session.createQuery("DELETE FROM Rezerwacje WHERE id=:id");
		querry.setLong("id", id);
		querry.executeUpdate();

		trx.commit();
		session.close();

	}
	
	public int save(Reservation	reservation) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		int id = (int) session.save(reservation);
		transaction.commit();
		session.close();
		return id;
	}
	
	public int saveToRezerwacje(Rezerwacje rezerwacje) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		int id = (int) session.save(rezerwacje);
		transaction.commit();
		session.close();
		return id;
	}

}
