package main.vehicle;

import main.enums.VehicleType;
import main.ticket.ParkingTicket;

public abstract class Vehicle {
	private String licenseNumber;
	private final VehicleType type;
	private ParkingTicket ticket;

	public Vehicle(String licenseNumber, VehicleType type) {
		this.licenseNumber = licenseNumber;
		this.type = type;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public ParkingTicket getTicket() {
		return ticket;
	}

	public VehicleType getType() {
		return type;
	}

	public Vehicle(VehicleType type) {
		this.type = type;
	}

	public void assignTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}
}