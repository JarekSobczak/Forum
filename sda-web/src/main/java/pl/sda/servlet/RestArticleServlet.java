package pl.sda.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.sda.service.ArticleService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/rest/articles"})
public class RestArticleServlet extends HttpServlet {

    private ArticleService service=new ArticleService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List articles = service.getArticles();
        sendAsJson(articles, response);
    }

    private void sendAsJson(List models, HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String jSon = gson.toJson(models);
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.print(jSon);
        writer.flush();
    }

}
