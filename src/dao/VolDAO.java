package dao;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helpers.HibernateHelper;
import model.Passager;
import model.Vol;;

public class VolDAO {
	
	
	public static Stream<Vol> list(){
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		Stream<Vol> result = null;
		
		try {
			t = s.beginTransaction();
			
			result = s.createQuery("FROM Vols").list().stream();
	
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
	
public static Vol create(Vol vol) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
	
		
		try {
			t = s.beginTransaction();
			s.save(vol);
			t.commit();
			
		} catch ( Exception e) {
			if (t != null) {
				t.rollback();
			}
		} finally {
			s.close();
		}
		
		
		return vol;
	}

}





