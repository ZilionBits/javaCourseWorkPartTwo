package lt.stud.techin.coursesmanagement.exceptions.handler;

import lt.stud.techin.coursesmanagement.exceptions.CourseByIdNotExistException;
import lt.stud.techin.coursesmanagement.exceptions.StartDateIsGreaterThanEndDateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StartDateIsGreaterThanEndDateException.class)
    public ResponseEntity<Map<String,String>> handleStartDateIsGreaterThanEndDateException(StartDateIsGreaterThanEndDateException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CourseByIdNotExistException.class)
    public ResponseEntity<Map<String,String>> handleCourseByIdNotExistException(CourseByIdNotExistException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
