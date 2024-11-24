package lt.techin.cinema.exceptions;

public class BookSeatAlreadyReservedException extends RuntimeException{
    public BookSeatAlreadyReservedException(String message) {
        super(message);
    }
}
