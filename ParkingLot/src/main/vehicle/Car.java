package main.vehicle;

import main.enums.VehicleType;

public class Car extends Vehicle {
	public Car(String plateNumber) {
		super(plateNumber, VehicleType.CAR);
	}
}