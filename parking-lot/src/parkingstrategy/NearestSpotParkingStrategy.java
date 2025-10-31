package parkingstrategy;

import models.ParkingFloor;
import models.ParkingSpot;
import vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestSpotParkingStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findAvailableParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            Optional<ParkingSpot> availableSpot = floor.findAvailableSpot(vehicle);
            if (availableSpot.isPresent()) return availableSpot;
        }
        return Optional.empty();
    }
}