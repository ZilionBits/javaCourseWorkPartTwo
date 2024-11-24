package lt.techin.cinema.service;

import lt.techin.cinema.dto.SeatRequest;
import lt.techin.cinema.dto.SeatResponse;
import lt.techin.cinema.exceptions.BookSeatAlreadyReservedException;
import lt.techin.cinema.exceptions.BookSeatGivenRowAndColumnValuesOutOfBound;
import lt.techin.cinema.seats.Cinema;
import lt.techin.cinema.seats.Seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatsServiceImpl implements SeatsService{
    List<Seat> seats = new ArrayList<>();
    Cinema cinema = new Cinema(seats);

    @Override
    public Cinema getSeats() {

        if(seats.isEmpty()) {
            int rows = cinema.getRows();
            int columns = cinema.getColumns();
            int priceFirstFourRows = 10;
            int priceAllLeftRows = 8;

            for (int row = 1; row <= rows; row++) {
                for (int column = 1; column <= columns; column++) {
                    if (row <= 4) {
                        seats.add(new Seat(row, column, priceFirstFourRows, false));
                    } else {
                        seats.add(new Seat(row, column, priceAllLeftRows, false));
                    }
                }
            }
        }
        return cinema;
    }

    @Override
    public SeatResponse bookSeat(SeatRequest seatRequest) {

        int requestedSeatIndex = 0;
        Seat requestedSeat = null;

        for(Seat seat : seats){
            if((seat.getRow()==seatRequest.getRow() && seat.getColumn()==seatRequest.getColumn())){
                requestedSeat = seats.get(requestedSeatIndex);
                break;
            }
            requestedSeatIndex++;
        }

        if(requestedSeat == null){
            throw new BookSeatGivenRowAndColumnValuesOutOfBound("The number of a row or a column is out of bounds!");
        }

        if(!requestedSeat.isReserved()){
             requestedSeat.setReserved(true);
             SeatResponse seatResponse = new SeatResponse();

             seatResponse.setRow(requestedSeat.getRow());
             seatResponse.setColumn(requestedSeat.getColumn());
             seatResponse.setPrice(requestedSeat.getPrice());

             return seatResponse;
        } else {
            throw new BookSeatAlreadyReservedException("The ticket has been already purchased!");
        }
    }
}
