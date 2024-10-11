package operations;

import java.util.ArrayList;
import java.util.List;
import entity.Booking;
import entity.Movie;
import entity.Seat;
import entity.Showtime;
import userException.BookingException;

public class Features {
    private List<Movie> movieList = new ArrayList<>();
    private List<Showtime> showtimes = new ArrayList<>(); 
    private List<Booking> bookings = new ArrayList<>();   

    
    public void addMovies() {
        movieList.add(new Movie(1, "SaLar"));
        movieList.add(new Movie(2, "Bahubali"));
        movieList.add(new Movie(3, "Doom2"));
    }

   
    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    // Display the list of movies
    public void displayMovieList() {
        for (Movie movie : movieList) {
            System.out.println(movie);
        }
    }

  
    public void checkSeatAvailability(List<Seat> seats) {
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    
    public void bookTicket(int bookingId, Showtime showtime, List<Seat> bookedSeats) throws BookingException {
        
        for (Seat seat : bookedSeats) {
            if (!seat.isAvailable()) {
                throw new BookingException("Seat " + seat.getSeatId() + " is already booked.");
            }
        }

        
        for (Seat seat : bookedSeats) {
            seat.setAvailable(false); 
        }

        // Create a new booking
        Booking booking = new Booking(bookingId, showtime, bookedSeats);
        bookings.add(booking); 

       
        System.out.println("Booking confirmed for booking ID: " + bookingId);
    }

  
    public void cancelBooking(String bookingId) throws BookingException {
        Booking bookingToCancel = null;

       
        for (Booking booking : bookings) {
            if (String.valueOf(booking.getBookingId()).equals(bookingId)) {
                bookingToCancel = booking;
                break;
            }
        }

       
        if (bookingToCancel == null) {
            throw new BookingException("Booking ID " + bookingId + " not found.");
        }

      
        for (Seat seat : bookingToCancel.getBookedSeats()) {
            seat.setAvailable(true);
        }

        
        bookings.remove(bookingToCancel);
        System.out.println("Booking cancelled successfully. Ticket ID: " + bookingId);
    }
}
