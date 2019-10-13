package _00_dao;

import java.util.ArrayList;

import _00_beans.EmpBean;

public interface EmpDao {
	public void add(EmpBean e);
	
	public void dele(EmpBean e);
	
	public void upDa(EmpBean e,String s);
	
	public void empById(EmpBean e);
	
	public ArrayList<EmpBean> empByAll();
	
	
}
