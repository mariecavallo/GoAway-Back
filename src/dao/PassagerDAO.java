package dao;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helpers.HibernateHelper;
import model.Passager;
import model.Vol;;

public class PassagerDAO {
	
	
public static Passager create(Passager passager) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
	
		
		try {
			t = s.beginTransaction();
			s.save(passager);
			t.commit();
			
		} catch ( Exception e) {
			if (t != null) {
				t.rollback();
			}
		} finally {
			s.close();
		}
		
		
		return passager;
	}

	public static Stream<Passager> list(){
	Session s = HibernateHelper.getSessionFactory().openSession();
	Transaction t = null;
	Stream<Passager> result = null;
	
	try {
		t = s.beginTransaction();
		
		result = s.createQuery("FROM Passagers").list().stream();

		t.commit();
	} catch ( Exception e) {
		if (t != null) {
			t.rollback();
		}
	} finally {
		s.close();
	}
	
	return result;
	
	}
	
public static Passager modify(Passager passager) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
	
		
		try {
			t = s.beginTransaction();
			s.update(passager);
			t.commit();
			
		} catch ( Exception e) {
			if (t != null) {
				t.rollback();
			}
		} finally {
			s.close();
		}
		
		
		return passager;
	}

}



