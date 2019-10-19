package controller;

import model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/login"} )
public class LoginController extends HttpServlet {

	private static final String PAGE_LOGIN_JSP = "/WEB-INF/jsp/login.jsp";
	private static final String PAGE_HOME_JSP = "/home";
	private static final String PAGE_SIGNUP_JSP = "/signup";

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		LoginModel model = new LoginModel();
		if ( model.isConnected( request ) ) {
			response.sendRedirect( request.getContextPath()+PAGE_HOME_JSP );
		} else {
			request.getRequestDispatcher( PAGE_LOGIN_JSP ).forward( request, response );
		}
	}

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		LoginModel model = new LoginModel();
		model.authenticate( request );
		request.setAttribute( "loginModel", model );
		doGet( request, response );
	}
}
