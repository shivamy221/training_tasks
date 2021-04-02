package task7;

public class EmployeeUsingRunnable implements Runnable {
	
	public int eno;
	public String ename;
	public int basicSal;
	
	public EmployeeUsingRunnable(int eno, String ename, int basicSal) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.basicSal = basicSal;
	}

	public void run() {
		String ThreadName=Thread.currentThread().getName();
		
		System.out.println("HRA of " + ThreadName + " is " + (basicSal*.10));
		System.out.println("DA of " + ThreadName + "  is " + (basicSal*.25));
		System.out.println("CA of " + ThreadName + "  is " + (basicSal*.10));
	}

	public static void main(String[] args) {
		EmployeeUsingRunnable emp1 = new EmployeeUsingRunnable(111,"AAA",30000);
		EmployeeUsingRunnable emp2 = new EmployeeUsingRunnable(112,"BBB",40000);
		EmployeeUsingRunnable emp3 = new EmployeeUsingRunnable(113,"CCC",50000);
		EmployeeUsingRunnable emp4 = new EmployeeUsingRunnable(114,"DDD",60000);
		EmployeeUsingRunnable emp5 = new EmployeeUsingRunnable(115,"EEE",70000);
		
		Thread t1 = new Thread(emp1);t1.setName("Thread 1");
		Thread t2 = new Thread(emp2);t1.setName("Thread 2");
		Thread t3 = new Thread(emp3);t1.setName("Thread 3");
		Thread t4 = new Thread(emp4);t1.setName("Thread 4");
		Thread t5 = new Thread(emp5);t1.setName("Thread 5");
	}

}
