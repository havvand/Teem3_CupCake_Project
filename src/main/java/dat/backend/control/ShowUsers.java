package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowUsers", value = "/ShowUsers")
public class ShowUsers extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    private ArrayList<User> allUsers = UserFacade.showUsers(connectionPool);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("users", allUsers);
        request.getRequestDispatcher("WEB-INF/adminshowusers.jsp").forward(request, response);

    }
}
