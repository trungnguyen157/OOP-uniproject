package main.parkingfloor;

import java.util.HashMap;

import main.parkingdisplayboard.ParkingDisplayBoard;
import main.parkingspot.CompactSpot;
import main.parkingspot.ElectricSpot;
import main.parkingspot.LargeSpot;
import main.parkingspot.MotorbikeSpot;
import main.parkingspot.ParkingSpot;
import main.vehicle.Vehicle;

public class ParkingFloor {
	private String name;
	private HashMap<String, CompactSpot> compactSpots;
	private HashMap<String, LargeSpot> largeSpots;
	private HashMap<String, MotorbikeSpot> motorbikeSpots;
	private HashMap<String, ElectricSpot> electricSpots;
	private ParkingDisplayBoard displayBoard;

	public ParkingFloor(String name) {
		this.name = name;
		displayBoard = new ParkingDisplayBoard();
		compactSpots = new HashMap<String, CompactSpot>();
		largeSpots = new HashMap<String, LargeSpot>();
		motorbikeSpots = new HashMap<String, MotorbikeSpot>();
		electricSpots = new HashMap<String, ElectricSpot>();
	}
	
	public int getFreeCompactSpotCount() {
		int count = 0;
		for (String key : compactSpots.keySet()) {
			if (compactSpots.get(key).isFree()) {
				count++;
			}
		}
		return count;
	}

	public int getFreeLargeSpotCount() {
		int count = 0;
		for (String key : largeSpots.keySet()) {
			if (largeSpots.get(key).isFree()) {
				count++;
			}
		}
		return count;
	}

	public int getFreeMotorbikeSpotCount() {
		int count = 0;
		for (String key : motorbikeSpots.keySet()) {
			if (motorbikeSpots.get(key).isFree()) {
				count++;
			}
		}
		return count;
	}

	public int getFreeElectricSpotCount() {
		int count = 0;
		for (String key : electricSpots.keySet()) {
			if (electricSpots.get(key).isFree()) {
				count++;
			}
		}
		return count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ParkingDisplayBoard getDisplayBoard() {
		return displayBoard;
	}

	public void addParkingSpot(ParkingSpot spot) {
		switch (spot.getType()) {
		case COMPACT:
			compactSpots.put(spot.getNumber(), (CompactSpot) spot);
			this.updateDisplayBoardForCompact();
			break;
		case LARGE:
			largeSpots.put(spot.getNumber(), (LargeSpot) spot);
			this.updateDisplayBoardForLarge();
			break;
		case MOTORBIKE:
			motorbikeSpots.put(spot.getNumber(), (MotorbikeSpot) spot);
			updateDisplayBoardForMotorbike();
			break;
		case ELECTRIC:
			electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
			this.updateDisplayBoardForElectric();
			break;
		default:
			System.out.println("Wrong parking spot type!");
		}
	}

	public void assignVehicleToSpot(Vehicle vehicle) {
		switch (vehicle.getType()) {
		case CAR:
			for (String key : compactSpots.keySet()) {
				if (compactSpots.get(key).isFree()) {
					compactSpots.get(key).assignVehicle(vehicle);
					updateDisplayBoardForCompact();
					break;
				}
			}
			break;
		case TRUCK:
			for (String key : largeSpots.keySet()) {
				if (largeSpots.get(key).isFree()) {
					largeSpots.get(key).assignVehicle(vehicle);
					updateDisplayBoardForLarge();
					break;
				}
			}
			break;
		case ELECTRIC:
			for (String key : electricSpots.keySet()) {
				if (electricSpots.get(key).isFree()) {
					electricSpots.get(key).assignVehicle(vehicle);
					updateDisplayBoardForElectric();
					break;
				}
			}
			break;
		case MOTORBIKE:
			for (String key : motorbikeSpots.keySet()) {
				if (motorbikeSpots.get(key).isFree()) {
					motorbikeSpots.get(key).assignVehicle(vehicle);
					updateDisplayBoardForMotorbike();
					break;
				}
			}
			break;
		default:
			break;
		}
	}

	private void updateDisplayBoardForCompact() {
		for (String key : compactSpots.keySet()) {
			if (compactSpots.get(key).isFree()) {
				this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
			}
		}
		this.displayBoard.showEmptySpotNumber();
	}

	private void updateDisplayBoardForLarge() {
		for (String key : largeSpots.keySet()) {
			if (largeSpots.get(key).isFree()) {
				this.displayBoard.setLargeFreeSpot(largeSpots.get(key));
			}
		}
		this.displayBoard.showEmptySpotNumber();
	}

	private void updateDisplayBoardForMotorbike() {
		for (String key : motorbikeSpots.keySet()) {
			if (motorbikeSpots.get(key).isFree()) {
				this.displayBoard.setMotorbikeFreeSpot(motorbikeSpots.get(key));
			}
		}
		this.displayBoard.showEmptySpotNumber();
	}

	private void updateDisplayBoardForElectric() {
		for (String key : electricSpots.keySet()) {
			if (electricSpots.get(key).isFree()) {
				this.displayBoard.setElectricFreeSpot(electricSpots.get(key));
			}
		}
		this.displayBoard.showEmptySpotNumber();
	}

	public void freeSpot(ParkingSpot spot) {
		spot.removeVehicle();
		switch (spot.getType()) {
		case COMPACT:
			this.updateDisplayBoardForCompact();
			break;
		case LARGE:
			this.updateDisplayBoardForLarge();
			break;
		case MOTORBIKE:
			this.updateDisplayBoardForMotorbike();
			break;
		case ELECTRIC:
			this.updateDisplayBoardForElectric();
			break;
		default:
			System.out.println("Wrong parking spot type!");
		}
	}
}