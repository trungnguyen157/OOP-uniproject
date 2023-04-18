package main.account;

import main.parkingdisplayboard.ParkingDisplayBoard;
import main.parkingfloor.ParkingFloor;
import main.parkinglot.ParkingLot;
import main.parkingspot.ParkingSpot;

public class Admin extends Account {
	public void addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor) {
		parkingLot.addParkingFloor(parkingFloor);
	};

	public void addParkingSpot(ParkingFloor parkingFloor, ParkingSpot spot) {
		parkingFloor.addParkingSpot(spot);
	};

	public void addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);

	public void addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);

	public void addEntrancePanel(EntrancePanel entrancePanel);

	public void addExitPanel(ExitPanel exitPanel);
}
