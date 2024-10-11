// Booking.java
package entity;

import java.util.List;

public class Booking {
    private int bookingId;
    private Showtime showtime;
    private List<Seat> bookedSeats;

    public Booking(int bookingId, Showtime showtime, List<Seat> bookedSeats) {
        this.bookingId = bookingId;
        this.showtime = showtime;
        this.bookedSeats = bookedSeats;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", showtime=" + showtime + ", bookedSeats=" + bookedSeats + '}';
    }
}
