package pl.sda.servlet;

import pl.sda.exception.IncorrectLoginOrPassword;

import pl.sda.persistance.entities.TbUser;
import pl.sda.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        TbUser tbUser=null;

        try {
            tbUser = service.getTbUser(login, password);

        } catch (IncorrectLoginOrPassword e) {
            res.sendRedirect("login.jsp");
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",tbUser);
        res.sendRedirect("index.jsp");
    }
}

