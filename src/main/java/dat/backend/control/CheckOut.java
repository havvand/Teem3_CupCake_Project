package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CupCakes;
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

@WebServlet(name = "checkOut", urlPatterns = {"/checkOut"} )
public class CheckOut extends HttpServlet
{
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");

        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        //response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getSession().getAttribute("orders");

        request.getRequestDispatcher("WEB-INF/checkout.jsp").forward(request,response);
    }

}