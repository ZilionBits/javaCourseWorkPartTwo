package lt.techin.cinema.exceptions;

public class BookSeatGivenRowAndColumnValuesOutOfBound extends RuntimeException{
    public BookSeatGivenRowAndColumnValuesOutOfBound(String message) {
        super(message);
    }
}
