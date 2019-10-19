package controller;

import model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet( name = "signupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

    private static final String PAGE_SIGNUP_JSP = "/WEB-INF/jsp/signup.jsp";

    public SignupController() {}

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher( PAGE_SIGNUP_JSP ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        LoginModel model = new LoginModel();
        model.authenticate( request );
        request.setAttribute( "loginModel", model );
        doGet( request, response );
    }

}
