package main.account;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import main.ticket.ParkingTicket;
import main.vehicle.Vehicle;

public class Admin extends Account {
	private int capacity;
    private List<Vehicle> parkedVehicles;

    public Admin(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new ArrayList<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (parkedVehicles.size() < capacity) {
            parkedVehicles.add(vehicle);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return parkedVehicles.remove(vehicle);
    }
    
    public boolean processTicket(ParkingTicket ticket) {
        LocalDateTime currentTime = LocalDateTime.now();

        boolean isExpired = currentTime.isAfter(ticket.getExpiredAt());

        boolean isUsedBeforeValid = currentTime.isBefore(ticket.getIssuedAt());

        boolean isValid = !isExpired && !isUsedBeforeValid;

        if (isExpired) {
            System.out.println("This ticket has expired.");
        } else if (isUsedBeforeValid) {
            System.out.println("This ticket was used before it was valid.");
        } else {
            System.out.println("This ticket is valid.");
        }

        return isValid;
    }
    
}
