package controller;

import bo.User;
import dal.UserDAO;
import model.HomeModel;
import org.w3c.dom.html.HTMLOptGroupElement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet( name = "homeController", urlPatterns = {"/home"}, loadOnStartup = 1 )
public class HomeController extends HttpServlet {

    private static final String PAGE_HOME_JSP = "/WEB-INF/jsp/home.jsp";
    private static final String PAGE_GAME_JSP = "/WEB-INF/jsp/game.jsp";

    public HomeController() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeModel model = new HomeModel();
        model.getLeaders(request);
        request.getRequestDispatcher( PAGE_HOME_JSP ).forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher( PAGE_GAME_JSP ).forward( request, response );
    }
}
