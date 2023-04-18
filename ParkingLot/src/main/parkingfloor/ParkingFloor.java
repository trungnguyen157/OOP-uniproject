package main.parkingfloor;

import java.util.HashMap;

import main.parkingdisplayboard.ParkingDisplayBoard;
import main.parkingspot.CompactSpot;
import main.parkingspot.ElectricSpot;
import main.parkingspot.HandicappedSpot;
import main.parkingspot.LargeSpot;
import main.parkingspot.MotorbikeSpot;
import main.parkingspot.ParkingSpot;
import main.vehicle.Vehicle;

public class ParkingFloor {
	private String name;
	private HashMap<String, HandicappedSpot> handicappedSpots;
	private HashMap<String, CompactSpot> compactSpots;
	private HashMap<String, LargeSpot> largeSpots;
	private HashMap<String, MotorbikeSpot> motorbikeSpots;
	private HashMap<String, ElectricSpot> electricSpots;
	private ParkingDisplayBoard displayBoard;
	private int freeHandicappedSpotCount;
	private int freeCompactSpotCount;
	private int freeLargeSpotCount;
	private int freeMotorbikeSpotCount;
	private int freeElectricSpotCount;

	public ParkingFloor(String name, HashMap<String, HandicappedSpot> handicappedSpots,
			HashMap<String, CompactSpot> compactSpots, HashMap<String, LargeSpot> largeSpots,
			HashMap<String, MotorbikeSpot> motorbikeSpots, HashMap<String, ElectricSpot> electricSpots,
			ParkingDisplayBoard displayBoard, int freeHandicappedSpotCount, int freeCompactSpotCount,
			int freeLargeSpotCount, int freeMotorbikeSpotCount, int freeElectricSpotCount) {
		this.name = name;
		this.handicappedSpots = handicappedSpots;
		this.compactSpots = compactSpots;
		this.largeSpots = largeSpots;
		this.motorbikeSpots = motorbikeSpots;
		this.electricSpots = electricSpots;
		this.displayBoard = displayBoard;
		this.freeHandicappedSpotCount = freeHandicappedSpotCount;
		this.freeCompactSpotCount = freeCompactSpotCount;
		this.freeLargeSpotCount = freeLargeSpotCount;
		this.freeMotorbikeSpotCount = freeMotorbikeSpotCount;
		this.freeElectricSpotCount = freeElectricSpotCount;
	}

	public void setFreeHandicappedSpotCount(int freeHandicappedSpotCount) {
		this.freeHandicappedSpotCount = freeHandicappedSpotCount;
	}

	public void setFreeCompactSpotCount(int freeCompactSpotCount) {
		this.freeCompactSpotCount = freeCompactSpotCount;
	}

	public void setFreeLargeSpotCount(int freeLargeSpotCount) {
		this.freeLargeSpotCount = freeLargeSpotCount;
	}

	public void setFreeMotorbikeSpotCount(int freeMotorbikeSpotCount) {
		this.freeMotorbikeSpotCount = freeMotorbikeSpotCount;
	}

	public void setFreeElectricSpotCount(int freeElectricSpotCount) {
		this.freeElectricSpotCount = freeElectricSpotCount;
	}

	public int getFreeHandicappedSpotCount() {
		return freeHandicappedSpotCount;
	}

	public int getFreeCompactSpotCount() {
		return freeCompactSpotCount;
	}

	public int getFreeLargeSpotCount() {
		return freeLargeSpotCount;
	}

	public int getFreeMotorbikeSpotCount() {
		return freeMotorbikeSpotCount;
	}

	public int getFreeElectricSpotCount() {
		return freeElectricSpotCount;
	}

	public ParkingFloor(String name) {
		this.setName(name);
	}

	public HashMap<String, HandicappedSpot> getHandicappedSpots() {
		return handicappedSpots;
	}

	public void setHandicappedSpots(HashMap<String, HandicappedSpot> handicappedSpots) {
		this.handicappedSpots = handicappedSpots;
	}

	public HashMap<String, CompactSpot> getCompactSpots() {
		return compactSpots;
	}

	public void setCompactSpots(HashMap<String, CompactSpot> compactSpots) {
		this.compactSpots = compactSpots;
	}

	public HashMap<String, LargeSpot> getLargeSpots() {
		return largeSpots;
	}

	public void setLargeSpots(HashMap<String, LargeSpot> largeSpots) {
		this.largeSpots = largeSpots;
	}

	public HashMap<String, MotorbikeSpot> getMotorbikeSpots() {
		return motorbikeSpots;
	}

	public void setMotorbikeSpots(HashMap<String, MotorbikeSpot> motorbikeSpots) {
		this.motorbikeSpots = motorbikeSpots;
	}

	public HashMap<String, ElectricSpot> getElectricSpots() {
		return electricSpots;
	}

	public void setElectricSpots(HashMap<String, ElectricSpot> electricSpots) {
		this.electricSpots = electricSpots;
	}

	public ParkingDisplayBoard getDisplayBoard() {
		return displayBoard;
	}

	public void setDisplayBoard(ParkingDisplayBoard displayBoard) {
		this.displayBoard = displayBoard;
	}

	public void addParkingSpot(ParkingSpot spot) {
		switch (spot.getType()) {
		case HANDICAPPED:
			handicappedSpots.put(spot.getNumber(), (HandicappedSpot) spot);
			break;
		case COMPACT:
			compactSpots.put(spot.getNumber(), (CompactSpot) spot);
			break;
		case LARGE:
			largeSpots.put(spot.getNumber(), (LargeSpot) spot);
			break;
		case MOTORBIKE:
			motorbikeSpots.put(spot.getNumber(), (MotorbikeSpot) spot);
			break;
		case ELECTRIC:
			electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
			break;
		default:
			System.out.println("Wrong parking spot type!");
		}
	}

	public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
		spot.assignVehicle(vehicle);
		switch (spot.getType()) {
		case HANDICAPPED:
			updateDisplayBoardForHandicapped(spot);
			break;
		case COMPACT:
			updateDisplayBoardForCompact(spot);
			break;
		case LARGE:
			updateDisplayBoardForLarge(spot);
			break;
		case MOTORBIKE:
			updateDisplayBoardForMotorbike(spot);
			break;
		case ELECTRIC:
			updateDisplayBoardForElectric(spot);
			break;
		default:
			System.out.println("Wrong parking spot type!");
		}
	}

	private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
		if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
			for (String key : handicappedSpots.keySet()) {
				if (handicappedSpots.get(key).isFree()) {
					this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	private void updateDisplayBoardForCompact(ParkingSpot spot) {
		if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
			for (String key : compactSpots.keySet()) {
				if (compactSpots.get(key).isFree()) {
					this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}
	
	private void updateDisplayBoardForLarge(ParkingSpot spot) {
		if (this.displayBoard.getLargeFreeSpot().getNumber() == spot.getNumber()) {
			for (String key : largeSpots.keySet()) {
				if (largeSpots.get(key).isFree()) {
					this.displayBoard.setLargeFreeSpot(largeSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
		if (this.displayBoard.getMotorbikeFreeSpot().getNumber() == spot.getNumber()) {
			for (String key : motorbikeSpots.keySet()) {
				if (motorbikeSpots.get(key).isFree()) {
					this.displayBoard.setMotorbikeFreeSpot(motorbikeSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}
	
	private void updateDisplayBoardForElectric(ParkingSpot spot) {
		if (this.displayBoard.getElectricFreeSpot().getNumber() == spot.getNumber()) {
			for (String key : electricSpots.keySet()) {
				if (electricSpots.get(key).isFree()) {
					this.displayBoard.setElectricFreeSpot(electricSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	public void freeSpot(ParkingSpot spot) {
		spot.removeVehicle();
		switch (spot.getType()) {
		case HANDICAPPED:
			freeHandicappedSpotCount++;
			break;
		case COMPACT:
			freeCompactSpotCount++;
			break;
		case LARGE:
			freeLargeSpotCount++;
			break;
		case MOTORBIKE:
			freeMotorbikeSpotCount++;
			break;
		case ELECTRIC:
			freeElectricSpotCount++;
			break;
		default:
			System.out.println("Wrong parking spot type!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}