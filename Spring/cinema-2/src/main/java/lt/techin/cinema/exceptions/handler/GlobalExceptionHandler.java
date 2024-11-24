package lt.techin.cinema.exceptions.handler;

import lt.techin.cinema.exceptions.BookSeatAlreadyReservedException;
import lt.techin.cinema.exceptions.BookSeatGivenRowAndColumnValuesOutOfBound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookSeatAlreadyReservedException.class)
    public ResponseEntity<Map<String,String>> handleBookSeatAlreadyReservedException(BookSeatAlreadyReservedException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(BookSeatGivenRowAndColumnValuesOutOfBound.class)
    public ResponseEntity<Map<String,String>> handleBookSeatGivenRowAndColumnValuesOutOfBound(BookSeatGivenRowAndColumnValuesOutOfBound ex){
        Map<String,String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
