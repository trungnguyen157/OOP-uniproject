package main.parkingdisplayboard;

import main.parkingspot.CompactSpot;
import main.parkingspot.ElectricSpot;
import main.parkingspot.HandicappedSpot;
import main.parkingspot.LargeSpot;
import main.parkingspot.MotorbikeSpot;

public class ParkingDisplayBoard {
	private String id;
	private HandicappedSpot handicappedFreeSpot;
	private CompactSpot compactFreeSpot;
	private LargeSpot largeFreeSpot;
	private MotorbikeSpot motorbikeFreeSpot;
	private ElectricSpot electricFreeSpot;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HandicappedSpot getHandicappedFreeSpot() {
		return handicappedFreeSpot;
	}

	public void setHandicappedFreeSpot(HandicappedSpot handicappedFreeSpot) {
		this.handicappedFreeSpot = handicappedFreeSpot;
	}

	public CompactSpot getCompactFreeSpot() {
		return compactFreeSpot;
	}

	public void setCompactFreeSpot(CompactSpot compactFreeSpot) {
		this.compactFreeSpot = compactFreeSpot;
	}

	public LargeSpot getLargeFreeSpot() {
		return largeFreeSpot;
	}

	public void setLargeFreeSpot(LargeSpot largeFreeSpot) {
		this.largeFreeSpot = largeFreeSpot;
	}

	public MotorbikeSpot getMotorbikeFreeSpot() {
		return motorbikeFreeSpot;
	}

	public void setMotorbikeFreeSpot(MotorbikeSpot motorbikeFreeSpot) {
		this.motorbikeFreeSpot = motorbikeFreeSpot;
	}

	public ElectricSpot getElectricFreeSpot() {
		return electricFreeSpot;
	}

	public void setElectricFreeSpot(ElectricSpot electricFreeSpot) {
		this.electricFreeSpot = electricFreeSpot;
	}

	public void showEmptySpotNumber() {
		String message = "";
		if (handicappedFreeSpot != null && handicappedFreeSpot.isFree()) {
			message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
		} else {
			message += "Handicapped is full";
		}
		message += System.lineSeparator();

		if (compactFreeSpot != null && compactFreeSpot.isFree()) {
			message += "Free Compact: " + compactFreeSpot.getNumber();
		} else {
			message += "Compact is full";
		}
		message += System.lineSeparator();

		if (largeFreeSpot != null && largeFreeSpot.isFree()) {
			message += "Free Large: " + largeFreeSpot.getNumber();
		} else {
			message += "Large is full";
		}
		message += System.lineSeparator();

		if (motorbikeFreeSpot != null && motorbikeFreeSpot.isFree()) {
			message += "Free Motorbike: " + motorbikeFreeSpot.getNumber();
		} else {
			message += "Motorbike is full";
		}
		message += System.lineSeparator();

		if (electricFreeSpot != null && electricFreeSpot.isFree()) {
			message += "Free Electric: " + electricFreeSpot.getNumber();
		} else {
			message += "Electric is full";
		}

		System.out.println(message);
		System.out.println();
	}
}
