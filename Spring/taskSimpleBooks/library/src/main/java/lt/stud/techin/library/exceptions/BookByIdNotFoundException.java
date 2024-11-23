package lt.stud.techin.library.exceptions;

public class BookByIdNotFoundException extends RuntimeException{
    public BookByIdNotFoundException(String message){
        super(message);
    }
}
