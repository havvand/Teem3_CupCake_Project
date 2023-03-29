package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TopAndBottom", value = "/TopAndBottom")
public class TopAndBottom extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        //session.setAttribute("user", null); // invalidating user object in session scope
        //String userTopping = request.getParameter("toppingType");
        ShoppingCart cart = new ShoppingCart("");
        String addTopping = request.getParameter("option1");
        String addBottom = request.getParameter("option2");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        cart.addOrder(addTopping, quantity);
        cart.addOrder(addBottom, quantity);
        request.getRequestDispatcher("WEB-INF/customer.jsp").forward(request,response);

        // Add functionality to add toppings to customer orders.

    }
}
