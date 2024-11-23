package lt.stud.techin.library.exceptions.handler;

import lt.stud.techin.library.exceptions.BookByIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookByIdNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleBookByIdNotFoundException(BookByIdNotFoundException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}