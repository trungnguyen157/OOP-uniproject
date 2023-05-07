package main.parkingspot;

import main.enums.ParkingSpotType;

public class LargeSpot extends ParkingSpot {
	public LargeSpot(String number) {
		super(number, ParkingSpotType.LARGE);
	}
}