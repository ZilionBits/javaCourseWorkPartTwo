package lt.stud.techin.coursesmanagement.exceptions;

public class CourseByIdNotExistException extends RuntimeException{
    public CourseByIdNotExistException(String message) {
        super(message);
    }
}
