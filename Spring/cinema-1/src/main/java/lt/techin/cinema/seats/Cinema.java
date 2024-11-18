package lt.techin.cinema.seats;

import java.util.List;


public class Cinema {
    private int rows = 9;
    private int columns = 9;
    private List<Seat> seats;

    public Cinema(List<Seat> seats) {
        this.seats = seats;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
