package lt.techin.cinema.dto;

import lombok.Data;

@Data
public class SeatResponse {
    private int row;
    private int column;
    private int price;

}
