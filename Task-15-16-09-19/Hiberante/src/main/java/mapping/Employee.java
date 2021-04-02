package mapping;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Employee {

	@Id
	private int empno;
	private String ename;
	private int sal;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Laptop laptop;
	@OneToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;

	public Employee(int empno, String ename, int sal, Laptop laptop, Vehicle vehicle) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.laptop = laptop;
		this.vehicle = vehicle;
	}

	public Employee() {
		super();
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", laptop=" + laptop + ", vehicle="
				+ vehicle + "]";
	}

	
	
	
	
	


}
