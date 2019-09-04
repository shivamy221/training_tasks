package task7;

public class EmployeeExtendThread extends Thread {
	
	public int eno;
	public String ename;
	public int basicSal;
	
	public EmployeeExtendThread(int eno, String ename, int basicSal) {
		this.eno = eno;
		this.ename = ename;
		this.basicSal = basicSal;
	}

	public void run(){
		String ThreadName=Thread.currentThread().getName();
		
		System.out.println("HRA of " + ThreadName + " is " + (basicSal*.10));
		System.out.println("DA of " + ThreadName + "  is " + (basicSal*.25));
		System.out.println("CA of " + ThreadName + "  is " + (basicSal*.10));
	}
	
	public static void main(String[] args) {
		
		EmployeeExtendThread emp1 = new EmployeeExtendThread(111,"AAA",30000);emp1.setName("employee-1");
		EmployeeExtendThread emp2 = new EmployeeExtendThread(112,"BBB",30000);emp2.setName("employee-2");
		EmployeeExtendThread emp3 = new EmployeeExtendThread(113,"CCC",30000);emp3.setName("employee-3");
		EmployeeExtendThread emp4 = new EmployeeExtendThread(114,"DDD",30000);emp4.setName("employee-4");
		EmployeeExtendThread emp5 = new EmployeeExtendThread(115,"EEE",30000);emp5.setName("employee-5");
		
		emp1.start();
		emp2.start();
		emp3.start();
		emp4.start();
		emp5.start();
		
	}

}
