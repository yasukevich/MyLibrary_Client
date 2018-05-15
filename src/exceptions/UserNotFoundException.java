package exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String textMessag){
        super(textMessag);
    }
}
