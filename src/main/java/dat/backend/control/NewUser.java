package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewUser", value = "/NewUser")
public class NewUser extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    /*public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmpassword");
        HttpSession session;
        if(!password.equals(confirmPassword)) {
            request.setAttribute("errormessage", "your passwords do not match");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
        try
        {
            User user = UserFacade.createUser(username, name, password, connectionPool);
            session = request.getSession();
            session.setAttribute("user", user); // adding user object to session scope
            request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }


    }

