package main.parkingspot;

import main.enums.ParkingSpotType;

public class ElectricSpot extends ParkingSpot {
	public ElectricSpot(String number) {
		super(number, ParkingSpotType.ELECTRIC);
	}
}