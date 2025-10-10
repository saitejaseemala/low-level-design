package vehicle;

public abstract class Vehicle {
    private String licenseNumber;
    private VehicleSize vehicleSize;

    public Vehicle(String licenseNumber, VehicleSize vehicleSize) {
        this.licenseNumber = licenseNumber;
        this.vehicleSize = vehicleSize;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }
}
