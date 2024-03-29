package pl.sda.servlet;

import pl.sda.persistance.entities.TbUser;
import pl.sda.service.ArticleService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addArticle"})
public class ArticleServlet extends HttpServlet {
    private ArticleService articleService=new ArticleService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String content=request.getParameter("content");
        String title=request.getParameter("title");
        HttpSession session=request.getSession();
        TbUser user=(TbUser) session.getAttribute("user");

        articleService.addArticle(user,title,content);
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("index.jsp");
    }
}
