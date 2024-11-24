package lt.techin.cinema.seats;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean reserved;
}
