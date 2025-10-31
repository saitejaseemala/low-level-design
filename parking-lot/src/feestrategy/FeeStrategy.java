package feestrategy;

import models.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
