// Showtime.java
package entity;

import java.util.List;

public class Showtime {
    private int showtimeId;
    private Movie movie;
    private List<Seat> seats;

    public Showtime(int showtimeId, Movie movie, List<Seat> seats) {
        this.showtimeId = showtimeId;
        this.movie = movie;
        this.seats = seats;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public Movie getMovie() {
        return movie;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Showtime{" + "showtimeId=" + showtimeId + ", movie=" + movie + ", seats=" + seats + '}';
    }
}
