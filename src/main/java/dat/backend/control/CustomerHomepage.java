package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CupCakes;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CupCakePickerFacade;
import dat.backend.model.persistence.UserFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "customerHomePage", urlPatterns = {"/customerHomePage"} )
public class CustomerHomepage extends HttpServlet
{
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    Map<String, CupCakes> CupCakesTop;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        response.setContentType("text/html");

        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        //response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");

        request.getRequestDispatcher("WEB-INF/customer.jsp").forward(request,response);
        System.out.println("LOLOLO");

        //session.setAttribute("user", null); // invalidating user object in session scope
        //String userTopping = request.getParameter("toppingType");
    }

}