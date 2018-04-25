package pl.mirkowski.lukasz.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.mirkowski.lukasz.model.Login;
import pl.mirkowski.lukasz.util.HibernateUtil;
  


public class LoginService {
	
	public boolean login(String login, String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query querry = session.createQuery("FROM Login WHERE login=:login and password=:pass and role='admin'");
		querry.setString("login", login);
		querry.setString("pass", password);
		

		@SuppressWarnings("unchecked")
		List<Login> list = querry.list();
		trx.commit();
		session.close();
		
		if (list.isEmpty()) {
			return false;
		}
		Login log = list.get(0);
		System.out.println("Zalogowano: " + log.getLogin());
		return true;

	}


}
