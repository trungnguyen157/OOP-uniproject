import main.panel.EntrancePanel;
import main.parkingfloor.ParkingFloor;
import main.parkingspot.CompactSpot;
import main.vehicle.Car;

public class MainClass {
	
	public static void main(String[] args) {
		EntrancePanel panel1 = new EntrancePanel("69");
		Car car1 = new Car("29A-19204");
		Car car2 = new Car("21A-12456");
		panel1.printTicket("249", car1);
		ParkingFloor floor1 = new ParkingFloor("Floor 1");
		CompactSpot spot1 = new CompactSpot("001");
		CompactSpot spot2 = new CompactSpot("002");
		CompactSpot spot3 = new CompactSpot("003");
		floor1.addParkingSpot(spot1);
		floor1.addParkingSpot(spot2);
		floor1.assignVehicleToSpot(car1);
		floor1.assignVehicleToSpot(car2);
		floor1.freeSpot(spot1);
		floor1.freeSpot(spot2);
		floor1.addParkingSpot(spot3);
		System.out.println(floor1.getFreeCompactSpotCount());
	}
	
}
