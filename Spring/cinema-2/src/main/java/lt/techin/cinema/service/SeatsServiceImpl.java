package lt.techin.cinema.service;

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

        int rows = cinema.getRows();
        int columns = cinema.getColumns();
        int priceFirstFourRows = 10;
        int priceAllLeftRows = 8;

        for (int row = 1; row <= rows ; row++) {
            for (int column = 1; column <= columns; column++) {
                if(row <= 4){
                    seats.add(new Seat(row, column, priceFirstFourRows));
                } else {
                    seats.add(new Seat(row, column, priceAllLeftRows));
                }
            }
        }
        return cinema;
    }

    @Override
    public Seat bookSeat() {
        return null;
    }
}
