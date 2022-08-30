package simulator.atm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SignInDB {
	
	public SignInDB() {
		super();
		
	}
	public SignInDB(int i) {
		SignIn si = new SignIn(i);
		Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(si);
		tx.commit();
		session.close();
		sf.close();
	}
	

}
