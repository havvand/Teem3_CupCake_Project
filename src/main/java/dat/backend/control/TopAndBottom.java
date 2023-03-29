package dat.backend.control;

import com.mysql.cj.xdevapi.Session;
import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
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
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "topAndBottom", urlPatterns = {"/topAndBottom"} )
public class TopAndBottom extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        //response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        ShoppingCart cart = null;
        try {
            cart = new ShoppingCart("");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        String addTopping = request.getParameter("option1");
        String addBottom = request.getParameter("option2");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ArrayList<CupCake> orders = cart.addOrder(cart.makeCupCake(addTopping, addBottom, quantity));
        session.setAttribute("orders", orders);

        request.getRequestDispatcher("WEB-INF/customer.jsp").forward(request,response);

    }

}