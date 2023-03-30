package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.DataFacade;
import dat.backend.model.persistence.DataMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Pay", value = "/Pay")
public class Pay extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("price");
        System.out.println("price");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getSession().getAttribute("price");
        int price = (int) request.getSession().getAttribute("price");
        int userId = (int) request.getSession().getAttribute("userId");
        DataFacade.writeToOrderData(price, userId, connectionPool);
        request.setAttribute("besked", "Tak for din bestilling!");


        request.getRequestDispatcher("WEB-INF/checkout.jsp").forward(request, response);


    }
}
