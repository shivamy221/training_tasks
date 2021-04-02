package empQue9;

import java.io.Serializable;

public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int eno;
	public  String ename;
	public  int sal;
	public  String desg;
	public  String dept;
	
	public Employee() {
		super();
	}

	public Employee(int eno, String ename, int sal, String desg, String dept) {
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.desg = desg;
		this.dept = dept;
	}
	
	
}
