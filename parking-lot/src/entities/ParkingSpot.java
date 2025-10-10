package entities;

import vehicle.Vehicle;
import vehicle.VehicleSize;

import static vehicle.VehicleSize.*;

public class ParkingSpot {

    private String spotId;
    private VehicleSize spotSize;
    private Vehicle parkedVehicle;
    private boolean isOccupied;


    public ParkingSpot(String spotId, VehicleSize spotSize) {
        this.spotId = spotId;
        this.spotSize = spotSize;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public synchronized void parkVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
        this.isOccupied = true;
    }

    public synchronized void unParkVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }


    public boolean canFitVehicle(Vehicle vehicle) {
        if (isOccupied) return false;

        return switch (vehicle.getVehicleSize()) {
            case SMALL -> spotSize == SMALL;
            case MEDIUM -> spotSize == MEDIUM || spotSize == LARGE;
            case LARGE -> spotSize == LARGE;
        };
    }
}
