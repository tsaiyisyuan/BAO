package _00_beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmpBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empno;
	private String ename;
	private String hiredate;
	private String salary;
	private String deptno;
	private String title;

	public EmpBean(String empno, String ename, String hiredate, String salary, String deptno, String title) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.salary = salary;
		this.deptno = deptno;
		this.title = title;
	}

	public EmpBean() {

	}

	@Id
	@Column(name = "empno")
	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	@Column(name = "ename")
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "hiredate")
	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "salary")
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Column(name = "deptno")
	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
