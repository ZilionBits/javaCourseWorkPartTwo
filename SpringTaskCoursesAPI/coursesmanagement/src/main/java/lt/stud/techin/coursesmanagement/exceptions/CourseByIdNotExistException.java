package lt.stud.techin.coursesmanagement.exceptions;

public class CourseByIdNotExistException extends RuntimeException{
    public CourseByIdNotExistException() {
        super("Course with the specified ID does not exist.");
    }
}
