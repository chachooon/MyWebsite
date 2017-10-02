package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//@WebFilter(filterName ="LoginCheckFilter", urlPatterns= {"list.jsp","detail.jsp"})
public class LoginCheckFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		boolean login = false;
		if(session != null) {
			if(session.getAttribute("email")!=null) {
				login =true;
			}
		}
		if(login) {
			chain.doFilter(request, response);
		}else {
			String target = httpServletRequest.getRequestURI();
			session.setAttribute("target",target);
			httpServletResponse.sendRedirect("/login.jsp?target="+target);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
//			dispatcher.forward(request, response);
			
		}
	}

}
