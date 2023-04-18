package main.ticket;

import java.time.LocalDateTime;

import main.enums.ParkingTicketStatus;

public class ParkingTicket {
	private String ticketNumber;
	private LocalDateTime payedAt;
	private double payedAmount;
	private ParkingTicketStatus status;

	public ParkingTicket(String ticketNumber, double payedAmount, ParkingTicketStatus status) {
		this.ticketNumber = ticketNumber;
		this.payedAmount = payedAmount;
		this.status = status;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public LocalDateTime getPayedAt() {
		return payedAt;
	}

	public void setPayedAt(LocalDateTime payedAt) {
		this.payedAt = payedAt;
	}

	public double getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(double payedAmount) {
		this.payedAmount = payedAmount;
	}

	public ParkingTicketStatus getStatus() {
		return status;
	}

	public void setStatus(ParkingTicketStatus status) {
		this.status = status;
	}
}
