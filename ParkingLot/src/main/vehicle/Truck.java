package main.vehicle;

import main.enums.VehicleType;

public class Truck extends Vehicle {
	public Truck(String plateNumber) {
		super(plateNumber, VehicleType.TRUCK);
	}
}
