package lt.techin.cinema.controller;

import lt.techin.cinema.seats.Cinema;
import lt.techin.cinema.seats.Seat;
import lt.techin.cinema.service.SeatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CinemaController {

    private final SeatsService seatsService;

    public CinemaController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @GetMapping("/seats")
    public Cinema getSeats(){

        return seatsService.getSeats();
    }

    @GetMapping("/purchase")
    public Seat bookSeat(){

        return seatsService.bookSeat();
    }

}
