package filter;

import model.LoginModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home"})
public class LoginFilter implements Filter {
	
	@Override
	public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)servletRequest).getSession(  );
		if ( null == session || null == session.getAttribute( LoginModel.ATT_AUTH_SESSION )) {
			((HttpServletRequest)servletRequest).getRequestDispatcher( "login" ).forward( servletRequest, servletResponse );
		} else {
			filterChain.doFilter( servletRequest, servletResponse );
		}
	}
}
