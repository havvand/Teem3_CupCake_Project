package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.CupCake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddBottom", value = "/AddBottom")
public class AddBottom extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    Map<String, CupCake> CupCakesTop;

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
        System.out.println("BOTTOM");
        String itemToAdd = request.getParameter("bottom");
        cart.addOrder(itemToAdd,0); //FIX
        cart.printOrderList();
        request.getRequestDispatcher("WEB-INF/customer.jsp").forward(request,response);
        // Add functionality to add toppings to customer orders.

    }
}
