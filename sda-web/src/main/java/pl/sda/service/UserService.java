package pl.sda.service;

import com.google.common.hash.Hashing;
import pl.sda.persistance.dao.UserDao;
import pl.sda.exception.IncorrectLoginOrPassword;
import pl.sda.persistance.entities.TbUser;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.nio.charset.StandardCharsets;

public class UserService {

    private UserDao dao=new UserDao();

    public TbUser getTbUser(String login, String password) throws IncorrectLoginOrPassword {
        TbUser userByLogin;
        String sha256hex = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        try {
            userByLogin=dao.getUserByLogin(login);
        }catch (NoResultException e){
            throw new IncorrectLoginOrPassword("no user in database");
        }catch (NonUniqueResultException e){
            throw new IncorrectLoginOrPassword("many users in database");
        }
        if (!userByLogin.getPassword().equals(sha256hex)){
            throw new IncorrectLoginOrPassword("incorrect password");
        }
        return  userByLogin;
    }
    public void addTbUser(String login, String password){
        dao.addTbUser(login,password);
    }
}
