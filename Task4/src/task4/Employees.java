package task4;

public class Employees {

	public long eno;
	public String ename;
	public int salary;
	public String designation;
	public String department;
	
	public Employees(long eno, String ename, int salary, String designation, String department) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.designation = designation;
		this.department = department;
	}

	public long getEno() {
		return this.eno;
	}

	public void setEno(long eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employees [eno=" + eno + ", ename=" + ename + ", salary=" + salary + ", designation=" + designation
				+ ", department=" + department + "]";
	}
	
	
	
	
	
}
