package entities;

import vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {

    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.parkingSpot = spot;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.ticketId = UUID.randomUUID().toString();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime() {
        this.exitTime = LocalDateTime.now();
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
