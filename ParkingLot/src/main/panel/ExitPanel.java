package main.panel;

import java.time.LocalDateTime;

import main.vehicle.Vehicle;

public class ExitPanel {
	private String id;

	public ExitPanel(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void scanTicket(Vehicle vehicle) {
		LocalDateTime exitTime = LocalDateTime.now();
		switch (vehicle.getTicket().getStatus()) {
		case ACTIVE:
			
		case PAID:
		case LOST:
		}
	}

	public void processPayment() {

	}
}
