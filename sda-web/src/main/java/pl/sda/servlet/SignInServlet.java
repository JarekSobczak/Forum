package pl.sda.servlet;

import pl.sda.exception.IncorrectLoginOrPassword;
import pl.sda.persistance.entities.TbUser;
import pl.sda.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/signin"})
public class SignInServlet extends HttpServlet {

    private UserService service=new UserService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        TbUser tbUser=null;
             service.addTbUser(login, password);
        res.sendRedirect("login.jsp");
    }
}
