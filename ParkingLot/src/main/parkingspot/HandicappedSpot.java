package main.parkingspot;

import main.enums.ParkingSpotType;

public class HandicappedSpot extends ParkingSpot {
	public HandicappedSpot(String number) {
		super(number, ParkingSpotType.HANDICAPPED);
	}
}
