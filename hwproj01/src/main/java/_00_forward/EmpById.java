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


@WebServlet("/EmpById")
public class EmpById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpById() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.getCurrentSession();
		
		request.setCharacterEncoding("UTF-8");
		String empno = request.getParameter("empno");
		System.out.println(empno);
		EmpBean emp = new EmpBean();
		emp.setEmpno(empno);
		EmpDaoJdbcImpl eDao = new EmpDaoJdbcImpl(session);
		
		eDao.empById(emp);
		
		System.out.println(emp.getEname());
		request.setAttribute("emp", emp);
		RequestDispatcher rd=request.getRequestDispatcher("/empupdata.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
