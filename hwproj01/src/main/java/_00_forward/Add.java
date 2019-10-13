package _00_forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _00_beans.EmpBean;
import _00_dao.EmpDaoJdbcImpl;
import util.HibernateUtil;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.getCurrentSession();
		
		request.setCharacterEncoding("UTF-8");
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String deptno = request.getParameter("deptno");
		String title = request.getParameter("title");
		EmpBean emp = new EmpBean();
		emp.setEmpno(empno);
		emp.setEname(ename);
		emp.setHiredate(hiredate);
		emp.setSalary(salary);
		emp.setDeptno(deptno);
		emp.setTitle(title);
		EmpDaoJdbcImpl eDao = new EmpDaoJdbcImpl(session);
		
		eDao.add(emp);
		
		RequestDispatcher rd = request.getRequestDispatcher("/EmpByAll");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
