package dat.backend.control;

import dat.backend.model.entities.CupCake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CustomerHomepage", value = "/CustomerHomepage")
public class CustomerHomepage extends HttpServlet {
    Map<String, CupCake> CupCakesTop;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");

        request.getRequestDispatcher("WEB-INF/customer.jsp").forward(request,response);

        //session.setAttribute("user", null); // invalidating user object in session scope
        //String userTopping = request.getParameter("toppingType");

    }
}
