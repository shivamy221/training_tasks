package com.wp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Emp {

@Id
private int empno;
private String ename;
private int sal;

public Emp(int empno, String ename, int sal) {
	super();
	this.empno = empno;
	this.ename = ename;
	this.sal = sal;
}

public Emp() {
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

@Override
public String toString() {
	return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + "]";
}


}
