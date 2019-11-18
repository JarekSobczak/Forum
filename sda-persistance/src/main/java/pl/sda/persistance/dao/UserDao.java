package pl.sda.persistance.dao;
import com.google.common.hash.Hashing;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.persistance.entities.TbUser;
import javax.persistence.NonUniqueResultException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import static pl.sda.persistance.HibernateUtil.getSessionFactory;

public class UserDao implements Serializable {

    public TbUser getUserByLogin(String login) throws HibernateException, NonUniqueResultException {
        try (Session session = getSessionFactory().openSession()) {
            Query query = session.createQuery("select e from " + TbUser.class.getName() + " e where e.login = :login");
            query.setParameter("login", login);
            session.beginTransaction();
            TbUser singleResult = (TbUser) query.getSingleResult();
            session.getTransaction().commit();
            return singleResult;
//        }catch (NoResultException e){
//            singleResult=null;
//        }
//            return singleResult;
        }
    }

    public void addTbUser(String login, String password){
        try (Session session = getSessionFactory().openSession()) {
            String sha256hex = Hashing.sha256()
                    .hashString(password, StandardCharsets.UTF_8)
                    .toString();
            TbUser user=new TbUser();
            user.setLogin(login);
            user.setPassword(sha256hex);
            session.getTransaction().begin();
            session.save(user);
            session.getTransaction().commit();
        }
    }
}
