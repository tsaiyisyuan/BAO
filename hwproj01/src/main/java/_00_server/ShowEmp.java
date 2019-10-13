package _00_server;

import java.io.IOException;
import java.util.ArrayList;

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


@WebServlet("/ShowEmp")
public class ShowEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.getCurrentSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String str1=request.getParameter("str");
		String[] strs = str1.split(" ");
		System.out.println(strs.length);
		EmpDaoJdbcImpl eDao = new EmpDaoJdbcImpl(session);
		if(str1.length()==0) {
			
			ArrayList<EmpBean> emps = eDao.empByAll();
			
			String s2="";
			for(EmpBean emp:emps) {
				String s1="";
				s1+="{"+"\"empno\":\""+emp.getEmpno()+"\",\"ename\":\""+emp.getEname()+"\",\"hiredate\":\""+emp.getHiredate()+"\",\"salary\":\""+emp.getSalary()+"\",\"deptno\":\""+emp.getDeptno()+"\",\"title\":\""+emp.getTitle()+"\"}";
				s2+=(s2.equals(""))?"["+s1:","+s1;
			}
			s2+="]";
			response.getWriter().print(s2);
		}else {
			
			ArrayList<EmpBean> emps = eDao.empByAll();
			
			ArrayList<EmpBean> emps2 = new ArrayList<EmpBean>();
			String s2="";
			for(EmpBean emp:emps) {
				boolean boo=false;
				for(String str:strs) {
					if(str.equals(emp.getEmpno())||str.equals(emp.getEname())||str.equals(emp.getHiredate())||str.equals(emp.getSalary())||str.equals(emp.getDeptno())||str.equals(emp.getTitle())) {
						boo=true;
					}
				}
				if(boo) {
					String s1="";
					s1+="{"+"\"empno\":\""+emp.getEmpno()+"\",\"ename\":\""+emp.getEname()+"\",\"hiredate\":\""+emp.getHiredate()+"\",\"salary\":\""+emp.getSalary()+"\",\"deptno\":\""+emp.getDeptno()+"\",\"title\":\""+emp.getTitle()+"\"}";
					s2+=(s2.equals(""))?"["+s1:","+s1;
				}
			}
			s2+="]";
			response.getWriter().print(s2);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
