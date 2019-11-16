package pl.sda.persistance.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.persistance.entities.TbUser;
import javax.persistence.NonUniqueResultException;
import java.io.Serializable;

import static pl.sda.persistance.HibernateUtil.getSessionFactory;

public class UserDao implements Serializable {

    public TbUser getUserByLogin(String login) throws HibernateException, NonUniqueResultException {
        try (Session session = getSessionFactory().openSession()) {
            Query query = session.createQuery("select e from " + TbUser.class.getName() + " e where e.login = :login");
            query.setParameter("login", login);
            session.beginTransaction();
            TbUser singleResult = null;
            singleResult = (TbUser) query.getSingleResult();
            session.getTransaction().commit();
            return singleResult;
//        }catch (NoResultException e){
//            singleResult=null;
//        }
//            return singleResult;
        }
    }
}
