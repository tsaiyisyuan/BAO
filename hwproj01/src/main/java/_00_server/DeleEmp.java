package _00_server;

import java.io.IOException;
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
 * Servlet implementation class DeleEmp
 */
@WebServlet("/DeleEmp")
public class DeleEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.getCurrentSession();
		
		request.setCharacterEncoding("UTF-8");
		String empno=request.getParameter("empno");
		EmpBean e = new EmpBean();
		e.setEmpno(empno);
		EmpDaoJdbcImpl eDao = new EmpDaoJdbcImpl(session);
		
		eDao.dele(e);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
