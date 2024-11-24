package lt.techin.cinema.seats;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class Cinema {
    private int rows = 9;
    private int columns = 9;
    private List<Seat> seats;

    public Cinema(List<Seat> seats) {
        this.seats = seats;
    }

}
