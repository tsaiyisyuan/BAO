package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

public class OpenSessionViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();

		try {
			sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("Transaction Begin");
			
			chain.doFilter(request, response);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
			System.out.println("Transaction Commit");
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			System.out.println("Transaction Rollback");
			chain.doFilter(request, response);
		} finally {
			sessionFactory.getCurrentSession().close();
			System.out.println("Session Closed");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
