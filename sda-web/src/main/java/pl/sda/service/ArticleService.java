package pl.sda.service;

import pl.sda.persistance.dao.ArticleDao;
import pl.sda.persistance.entities.TbUser;

public class ArticleService {
    private ArticleDao dao=new ArticleDao();

    public void addArticle(TbUser user, String content) {
        dao.add(user, content);
    }
}
