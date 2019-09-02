package task5A;

public class Employee {

	public int eno;
	public String ename;
	public int sal;
	public String desg;
	
	public Employee(int eno, String ename, int sal, String desg) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.desg = desg;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", desg=" + desg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desg == null) ? 0 : desg.hashCode());
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + eno;
		result = prime * result + sal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (desg == null) {
			if (other.desg != null)
				return false;
		} else if (!desg.equals(other.desg))
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (eno != other.eno)
			return false;
		if (sal != other.sal)
			return false;
		return true;
	}
	
	
	
	
}
