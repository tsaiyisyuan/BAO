package _00_forward;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import _00_beans.EmpBean;
import _00_dao.EmpDaoJdbcImpl;

import util.HibernateUtil;

/**
 * Servlet implementation class EmpByAll
 */
@WebServlet("/EmpByAll")
public class EmpByAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpByAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.getCurrentSession();
		
			EmpDaoJdbcImpl eDao = new EmpDaoJdbcImpl(session);
			ArrayList<EmpBean> list = eDao.empByAll();
			
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("emps", list);

		RequestDispatcher rd=request.getRequestDispatcher("/index01.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
