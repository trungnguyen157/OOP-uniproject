package main.parkingspot;

import main.enums.ParkingSpotType;

public class MotorbikeSpot extends ParkingSpot {
	public MotorbikeSpot(String number) {
		super(number, ParkingSpotType.MOTORBIKE);
	}
}