package pl.sda.service;

import pl.sda.persistance.dao.ArticleDao;
import pl.sda.persistance.entities.TbUser;

import java.util.List;

public class ArticleService {
    private ArticleDao dao=new ArticleDao();

    public void addArticle(TbUser user,String title, String content) {
        dao.add(user,title, content);
    }
    public List getArticles(){
        return dao.getArticles();
    }
}
