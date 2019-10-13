package _00_dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;

import _00_beans.EmpBean;


public class EmpDaoJdbcImpl implements EmpDao {

	private Session session;

	public EmpDaoJdbcImpl(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	//新增
	@Override
	public void add(EmpBean e) {
		session.save(e);
	}
	//刪除
	@Override
	public void dele(EmpBean e) {
		session.delete(e);
	}
	//更新
	@Override
	public void upDa(EmpBean e,String s) {
		EmpBean result = getSession().get(EmpBean.class, s);
		if(result!=null) {
			result.setEmpno(e.getEmpno());
			result.setEname(e.getEname());
			result.setHiredate(e.getHiredate());
			result.setSalary(e.getSalary());
			result.setDeptno(e.getDeptno());
			result.setTitle(e.getTitle());
		}

	}
	//單筆查詢
	@Override
	public void empById(EmpBean e) {
		Query query = session.createQuery("from EmpBean where empno="+e.getEmpno());
		ArrayList<EmpBean> list = (ArrayList<EmpBean>) query.list();
		for(EmpBean b1:list) {
			e.setEmpno(b1.getEmpno());
			e.setEname(b1.getEname());
			e.setHiredate(b1.getHiredate());
			e.setSalary(b1.getSalary());
			e.setDeptno(b1.getDeptno());
			e.setTitle(b1.getTitle());
		}

	}
	//查詢全部
	@Override
	public ArrayList<EmpBean> empByAll() {
		Query query = session.createQuery("from EmpBean");
		return (ArrayList<EmpBean>) query.list();

	}

	

}
