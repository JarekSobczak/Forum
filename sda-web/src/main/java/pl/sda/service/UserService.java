package pl.sda.service;

import pl.sda.persistance.dao.UserDao;
import pl.sda.exception.IncorrectLoginOrPassword;
import pl.sda.persistance.entities.TbUser;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

public class UserService {

    private UserDao dao=new UserDao();

    public TbUser getTbUser(String login, String password) throws IncorrectLoginOrPassword {
        TbUser userByLogin;
        try {
            userByLogin=dao.getUserByLogin(login);
        }catch (NoResultException e){
            throw new IncorrectLoginOrPassword("no user in database");
        }catch (NonUniqueResultException e){
            throw new IncorrectLoginOrPassword("many users in database");
        }
        if (!userByLogin.getPassword().equals(password)){
            throw new IncorrectLoginOrPassword("incorrect password");
        }
        return  userByLogin;
    }
}
