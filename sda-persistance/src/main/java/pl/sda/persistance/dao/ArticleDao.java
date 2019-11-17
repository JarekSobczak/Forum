package pl.sda.persistance.dao;

import org.hibernate.Session;
import pl.sda.persistance.HibernateUtil;
import pl.sda.persistance.entities.TbArticle;
import pl.sda.persistance.entities.TbUser;

public class ArticleDao {

    public void add(TbUser user, String content){

      try (Session session= HibernateUtil.getSessionFactory().openSession()) {

          TbArticle tbArticle = new TbArticle();
          tbArticle.setContent(content);
          tbArticle.setUser(user);
          session.beginTransaction();
          session.save(tbArticle);
          session.getTransaction().commit();
      }
    }
}
