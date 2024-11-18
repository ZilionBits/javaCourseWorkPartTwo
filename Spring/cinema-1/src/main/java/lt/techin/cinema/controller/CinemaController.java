package lt.techin.cinema.controller;

import lt.techin.cinema.seats.Cinema;
import lt.techin.cinema.service.SeatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class CinemaController {

    private SeatsService seatsService;

    public CinemaController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @GetMapping
    public Cinema getSeats(){

        return seatsService.getSeats();
    }

}
