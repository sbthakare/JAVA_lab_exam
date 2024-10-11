// Seat.java
package entity;

public class Seat {
    private int seatId;
    private boolean isAvailable;

    public Seat(int seatId, boolean isAvailable) {
        this.seatId = seatId;
        this.isAvailable = isAvailable;
    }

    public int getSeatId() {
        return seatId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Seat{" + "seatId=" + seatId + ", isAvailable=" + isAvailable + '}';
    }
}
