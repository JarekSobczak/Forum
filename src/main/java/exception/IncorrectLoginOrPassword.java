package exception;

public class IncorrectLoginOrPassword extends Exception {

    public IncorrectLoginOrPassword(String message){
        super(message);
    }
}
