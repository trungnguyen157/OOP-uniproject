package main.parkingspot;

import main.enums.ParkingSpotType;
import main.vehicle.Vehicle;

public abstract class ParkingSpot {
	private String number;
	private boolean free;
	private Vehicle vehicle;
	private final ParkingSpotType type;

	public ParkingSpot(String number, boolean free, Vehicle vehicle, ParkingSpotType type) {
		this.number = number;
		this.free = free;
		this.vehicle = vehicle;
		this.type = type;
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

	public void setFree(boolean free) {
		this.free = free;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpotType getType() {
		return type;
	}

	public ParkingSpot(ParkingSpotType type) {
		this.type = type;
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