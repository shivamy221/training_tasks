package mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.wp.Util;

public class AddLaptop {

	public static void main(String[] args) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		
		Laptop l1 = new Laptop("L111","Dell",30000);
		Laptop l2 = new Laptop("L112","Dell",35000);
		Laptop l3 = new Laptop("L113","Dell",40000);
		
		Transaction tr=session.beginTransaction();
		session.save(l1);
		session.save(l2);
		session.save(l3); 
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");

	}

}
