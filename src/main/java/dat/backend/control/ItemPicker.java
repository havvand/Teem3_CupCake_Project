package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CupCakePickerFacade;
import dat.backend.model.persistence.UserFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "itemPicker", urlPatterns = {"/itemPicker"} )
public class ItemPicker extends HttpServlet
{
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        //response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        //session.setAttribute("user", null); // invalidating user object in session scope
        String userTopping = request.getParameter("topping-type");
        String userBottom = request.getParameter("bottom-type");

        try
        {

            String top = CupCakePickerFacade.PickTop(userTopping, connectionPool);
            System.out.println(top + " SAY WHAT");
            String bottom = CupCakePickerFacade.PickBottom(userBottom, connectionPool);

            session.setAttribute("topping-type", top);
            session.setAttribute("bottom-type", bottom);

            request.getRequestDispatcher("WEB-INF/customer.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}