// Programmed by Caleb Snell
// Class that defines / implements methods for creating / organizing a parking lot

import java.util.*;

public class ParkingLot {
	
	// Private data for parkingSpots array and object
	private ArrayList<ParkingSpot> parkingSpots;
	// create default parkingSpot object
	public ParkingSpot parkingSpot;
			
	//-----CONSTRUCTORS-----//
	public ParkingLot () {
		
		//ParkingSpot parkingSpot = new ParkingSpot();
		ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
		
		// loop through and create 20 default parkingSpots
		for (int ct1 = 0; ct1 < 19; ct1++) {
			parkingSpots.add(new ParkingSpot());
		}
		// set 4 parkingSpots to be handicapped only
		for (int ct2 = 0; ct2 < 3; ct2++) {
			//parkingSpots.set(ct2, parkingSpot.setHandicappedOnly(true));
			parkingSpots.get(ct2).setHandicappedOnly(true);
		}
		System.out.println("yoyo");
		parkingSpots.get(0);		
	}

	//-----MODIFIERS-----//
	public int addCar (String make, String model, String color, boolean isHandicapped) {
		if (isHandicapped) {
			int ct3 = 0;
			while(parkingSpots.get(ct3).getCarMake() != "None" && parkingSpots.get(ct3).getHandicappedOnly() != true) {
				ct3++;
				if(ct3 >= 20) {
					return -1;
				}
			}
			parkingSpots.set(ct3, parkingSpot.setCarMake(make));
			parkingSpots.set(ct3, parkingSpot.setCarModel(model));
			parkingSpots.set(ct3, parkingSpot.setCarColor(color));
			parkingSpots.set(ct3, parkingSpot.setCarIsHandicapped(isHandicapped));
			return ct3;
		}
		else {
			int ct4 = 0;
			parkingSpots.get(0);
			while(!parkingSpots.get(ct4).getCarMake().equals("None")) {
				ct4++;
				System.out.println("a");
				if(ct4 >= 20) {
					return -1;
				}
			}
			parkingSpots.set(ct4, parkingSpot.setCarMake(make));
			parkingSpots.set(ct4, parkingSpot.setCarModel(model));
			parkingSpots.set(ct4, parkingSpot.setCarColor(color));
			parkingSpots.set(ct4, parkingSpot.setCarIsHandicapped(isHandicapped));
			return ct4;
		}
		
	}
}
