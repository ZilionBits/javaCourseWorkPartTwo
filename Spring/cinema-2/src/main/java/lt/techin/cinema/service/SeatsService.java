package lt.techin.cinema.service;

import lt.techin.cinema.dto.SeatRequest;
import lt.techin.cinema.dto.SeatResponse;
import lt.techin.cinema.seats.Cinema;

public interface SeatsService {

    Cinema getSeats();

    SeatResponse bookSeat(SeatRequest seatRequest);
}
