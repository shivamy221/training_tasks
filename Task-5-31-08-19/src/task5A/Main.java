package task5A;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		HashMap<Employee,Project> map = new HashMap<>();
		
		Employee e1 = new Employee(111,"manav",20000,"tester");
		Employee e2 = new Employee(112,"sunny",80000,"tester");
		Employee e3 = new Employee(113,"akash",60000,"tester");
		Employee e4 = new Employee(114,"vishnu",40000,"tester");
		Employee e5 = new Employee(115,"shivam",80000,"developer");
		
		Project p1 = new Project(501,"secApp",4,"IBM");
		Project p2 = new Project(502,"msgApp",5,"TCS");
		Project p3 = new Project(503,"calApp",6,"WIPRO");
		Project p4 = new Project(504,"desktopApp",7,"POGO");
		Project p5 = new Project(505,"connectApp",8,"HP");
		
		map.put(e1, p1);
		map.put(e2, p2);
		map.put(e3, p3);
		map.put(e4, p4);
		map.put(e5, p5);
		
		System.out.println(map);
	}

}
