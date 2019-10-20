package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class HomeModel {

    public HomeModel() {}

    public void getLeaders(HttpServletRequest request) {
        UserDAO dao = (UserDAO) DAOFactory.getUserDAO();
        try {
            List<User> leaders = dao.leaderboard();

            HttpSession session = request.getSession(true);
            session.setAttribute("leaderboard", leaders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
