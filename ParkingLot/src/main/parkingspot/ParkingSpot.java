package main.parkingspot;

import main.enums.ParkingSpotType;
import main.vehicle.Vehicle;

public abstract class ParkingSpot {
	private String number;
	private boolean free;
	private Vehicle vehicle;
	private final ParkingSpotType type;

	public ParkingSpot(String number, ParkingSpotType type) {
		this.number = number;
		this.type = type;
		free = true;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isFree() {
		return free;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public ParkingSpotType getType() {
		return type;
	}

	public void assignVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		free = false;
	}

	public void removeVehicle() {
		this.vehicle = null;
		free = true;
	}
}