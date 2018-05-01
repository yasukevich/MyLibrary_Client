package exceptions;

public class LibraryNotFoundException extends Exception{
    public LibraryNotFoundException(String textMessag){
        super(textMessag);
    }
}
