package userinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Movie;
import entity.Seat;
import entity.Showtime;
import operations.Features;
import userException.BookingException;

public class CinemaBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Features features = new Features();
        features.addMovies();

        // Sample seats for demonstration
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) { // 10 seats for simplicity
            seats.add(new Seat(i, true)); // All seats are initially available
        }

        // Sample showtime
        Showtime showtime = new Showtime(1, new Movie(1, "SaLar"), seats);
        features.addShowtime(showtime);

        while (true) {
            System.out.println("\nCinema Booking System:");
            System.out.println("1. Check seat availability");
            System.out.println("2. Check movie list");
            System.out.println("3. Book ticket");
            System.out.println("4. Cancel booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        // Display seat availability
                        System.out.println("Seat availability:");
                        features.checkSeatAvailability(seats);
                        break;
                    case 2:
                        features.displayMovieList();
                        break;
                    case 3:
                        System.out.print("Enter booking ID: ");
                        int bookingId = scanner.nextInt();
                        System.out.print("Select seats (comma-separated, e.g., 1,2,3): ");
                        String[] seatInputs = scanner.next().split(",");

                        List<Seat> bookedSeats = new ArrayList<>();
                        for (String seatInput : seatInputs) {
                            int seatId = Integer.parseInt(seatInput.trim());
                            Seat seat = seats.get(seatId - 1); // Adjust for zero-based index
                            bookedSeats.add(seat);
                        }

                        // Attempt to book the ticket
                        features.bookTicket(bookingId, showtime, bookedSeats);
                        break;
                    case 4:
                        System.out.print("Enter booking ID to cancel: ");
                        String bookingIdToCancel = scanner.next();
                        features.cancelBooking(bookingIdToCancel);
                        break;
                    case 5:
                        System.out.println("Thank you for using the Cinema Booking System!");
                        scanner.close();
                        return; 
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (BookingException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
