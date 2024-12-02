package lt.stud.techin.coursesmanagement.exceptions;

public class StartDateIsGreaterThanEndDateException extends RuntimeException{
    public StartDateIsGreaterThanEndDateException(String message){
        super(message);
    }
}
