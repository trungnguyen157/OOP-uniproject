package main.parkingspot;

import main.enums.ParkingSpotType;

public class CompactSpot extends ParkingSpot {
	public CompactSpot(String number) {
		super(number, ParkingSpotType.COMPACT);
	}
}