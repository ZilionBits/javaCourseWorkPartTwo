package lt.techin.cinema.service;

import lt.techin.cinema.seats.Cinema;
import lt.techin.cinema.seats.Seat;

public interface SeatsService {

    Cinema getSeats();

    Seat bookSeat();
}
