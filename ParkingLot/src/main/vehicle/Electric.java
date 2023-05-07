package main.vehicle;

import main.enums.VehicleType;

public class Electric extends Vehicle {
	public Electric(String plateNumber) {
		super(plateNumber, VehicleType.ELECTRIC);
	}
}
