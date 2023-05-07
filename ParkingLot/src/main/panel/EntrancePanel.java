package main.panel;

import main.ticket.ParkingTicket;
import main.vehicle.Vehicle;

public class EntrancePanel {
	private String id;
	
	public EntrancePanel(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void printTicket(String number, Vehicle vehicle) {
		ParkingTicket ticket = new ParkingTicket(number);
		vehicle.assignTicket(ticket);
	}
}
