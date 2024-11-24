package lt.techin.cinema.controller;

import lombok.AllArgsConstructor;
import lt.techin.cinema.dto.SeatRequest;
import lt.techin.cinema.dto.SeatResponse;
import lt.techin.cinema.seats.Cinema;
import lt.techin.cinema.service.SeatsService;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping
public class CinemaController {

    private final SeatsService seatsService;

    @GetMapping("/seats")
    public Cinema getSeats(){

        return seatsService.getSeats();
    }

    @PostMapping("/purchase")
    public SeatResponse bookSeat(@RequestBody SeatRequest seatRequest){
        return seatsService.bookSeat(seatRequest);
    }

}
