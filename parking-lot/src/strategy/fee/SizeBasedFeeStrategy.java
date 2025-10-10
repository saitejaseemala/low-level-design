package strategy.fee;

import entities.ParkingTicket;
import vehicle.VehicleSize;

import java.time.Duration;
import java.util.Map;

public class SizeBasedFeeStrategy implements FeeStrategy {

    private static final Map<VehicleSize, Double> RATE_PER_VEHICLE_SIZE = Map.of(VehicleSize.SMALL, 20.0, VehicleSize.MEDIUM, 40.0, VehicleSize.LARGE, 60.0);

    @Override
    public double calculateFee(ParkingTicket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = Math.max(1, (long) Math.ceil(duration.toMinutes() / 60.0));
        double amount = RATE_PER_VEHICLE_SIZE.get(ticket.getVehicle().getVehicleSize());
        return hours * amount;
    }
}
