package lt.techin.cinema.service;

import lt.techin.cinema.seats.Cinema;
import lt.techin.cinema.seats.Seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatsServiceImpl implements SeatsService{

    @Override
    public Cinema getSeats() {

        List<Seat> seats = new ArrayList<>();
        int rows = 9;
        int columns = 9;

        for (int row = 1; row <= rows ; row++) {
            for (int column = 1; column <= columns; column++) {
                seats.add(new Seat(row, column));
            }
        }

        return new Cinema(seats);
    }
}
