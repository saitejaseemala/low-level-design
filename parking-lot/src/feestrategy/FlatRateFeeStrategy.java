package feestrategy;

import models.ParkingTicket;

import java.time.Duration;

public class FlatRateFeeStrategy implements FeeStrategy {

    private static final double RATE_PER_HOUR = 50;

    @Override
    public double calculateFee(ParkingTicket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = (long) Math.ceil(duration.toMinutes() / 60.0);
        return hours * RATE_PER_HOUR;
    }
}
