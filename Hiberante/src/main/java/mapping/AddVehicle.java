package mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wp.Util;

public class AddVehicle {

	public static void main(String[] args) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		
		Vehicle v1 = new Vehicle("ak5789","Bajaj","Pulsar 150",80000);
		Vehicle v2 = new Vehicle("ak5790","Bajaj","Pulsar 180",92000);
		Vehicle v3 = new Vehicle("ak5791","Bajaj","Pulsar 200",110000);
		
		Transaction tr=session.beginTransaction();
		session.save(v1);
		session.save(v2);
		session.save(v3); 
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");


	}

}
