package task5B;

import java.util.*;

public class SortEmployees implements Comparator<Employees> {
	
	 public int sF;
	 public int sO;
		
	public SortEmployees(int sF, int sO) {
		super();
		this.sF = sF;
		this.sO = sO;
	}

	@Override
	public int compare(Employees emp1,Employees emp2) {
		if(this.sF==1) {
			if(this.sO==1) {
				return (int)(emp1.eno-emp2.eno);
			} else if(this.sO==2) {
				return (int)(emp2.eno-emp1.eno);
			}
		} else if(this.sF==2) {
			if(this.sO==1) {
				return emp1.ename.compareTo(emp2.ename);
			} else if(this.sO==2) {
				return emp2.ename.compareTo(emp1.ename);
			}
		} else if(this.sF==3) {
			if(this.sO==1) {
				return (emp1.salary-emp2.salary);
			} else if(this.sO==2) {
				return (emp2.salary-emp1.salary);
			}
		} 
		return 0;
	}
	

}
