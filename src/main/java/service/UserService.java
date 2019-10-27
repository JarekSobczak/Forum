package service;

import exception.IncorrectLoginOrPassword;
import persistance.TbUser;

public class UserService {

    public TbUser getTbUser(String login, String password) throws IncorrectLoginOrPassword {
        if (login.equals(password)) {
            return new TbUser(1,login);
        }else throw new IncorrectLoginOrPassword("incorrect login or password");
    }
}
