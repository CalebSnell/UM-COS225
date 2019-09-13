
public class ParkingTester {

	public static void main(String[] args) {
		// Create new parkingLot object
		ParkingLot parkingLot = new ParkingLot();
		int carPos = 0;
		
		// Prints parking lot availability, handicap spots + standard spots
		System.out.printf("%s%s%n", "Handicap / Stanard Spots: ", parkingLot.toString());
		
		// Adds a car with given parameters
		carPos = parkingLot.addCar("Lexus", "RX", "Blue", true, carPos);
		System.out.printf("%s%s%n", "Handicap / Stanard Spots: ", parkingLot.toString());
		// Prints position of previously added car
		System.out.printf("%s%d%n","Your car is in spot: ", carPos);
		
		// Adds custom car
		carPos = parkingLot.addCar("Testla", "Test S", "Silver", true, carPos);
		System.out.printf("%s%s%n", "Handicap / Stanard Spots: ", parkingLot.toString());
		System.out.printf("%s%d%n","Your car is in spot: ", carPos);
	}

}
