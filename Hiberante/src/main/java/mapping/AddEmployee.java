package mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wp.Util;

public class AddEmployee {

	public static void main(String[] args) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		
		Employee e1 = new Employee(1001, "Shivam", 30000, new Laptop("l111"), new Vehicle("ak5789"));
		Employee e2 = new Employee(1002, "manav", 30000, new Laptop("l112"), new Vehicle("ak5790"));
		Employee e3 = new Employee(1003, "sunny", 30000, new Laptop("l112"), new Vehicle("ak5791"));
		
		Transaction tr=session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(e3); 
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");
	}

}
