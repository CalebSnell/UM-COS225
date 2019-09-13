// Programmed by Caleb Snell
// Class that defines / implements methods for creating / organizing a parking lot

import java.util.*;

public class ParkingLot {
	
	// Private data for parkingSpots array and object
	//private ArrayList<ParkingSpot> parkingSpots;
	private ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	// create default parkingSpot object
	public ParkingSpot parkingSpot;
			
	//-----CONSTRUCTORS-----//
	public ParkingLot () {
		
		//ParkingSpot parkingSpot = new ParkingSpot();
		
		
		// loop through and create 20 default parkingSpots
		for (int ct1 = 0; ct1 < 19; ct1++) {
			parkingSpots.add(new ParkingSpot());
		}
		// set 4 parkingSpots to be handicapped only
		for (int ct2 = 0; ct2 < 3; ct2++) {
			//parkingSpots.set(ct2, parkingSpot.setHandicappedOnly(true));
			parkingSpots.get(ct2).setHandicappedOnly(true);
		}
	}

	//-----MODIFIERS-----//
	public int addCar (String make, String model, String color, boolean isHandicapped) {
		if (isHandicapped) {
			int ct3 = 0;
			while(!parkingSpots.get(ct3).getCarMake().equals("None") && !parkingSpots.get(ct3).getHandicappedOnly()) {
				ct3++;
				if(ct3 >= 20) {
					return -1;
				}
			}
			parkingSpots.get(ct3).setCarMake(make);
			parkingSpots.get(ct3).setCarModel(model);
			parkingSpots.get(ct3).setCarColor(color);
			parkingSpots.get(ct3).setCarIsHandicapped(isHandicapped);
			return ct3;
		}
		else {
			int ct4 = 0;
			while(!parkingSpots.get(ct4).getCarMake().equals("None")) {
				ct4++;
				if(ct4 >= 20) {
					return -1;
				}
			}
			parkingSpots.get(ct4).setCarMake(make);
			parkingSpots.get(ct4).setCarModel(model);
			parkingSpots.get(ct4).setCarColor(color);
			parkingSpots.get(ct4).setCarIsHandicapped(isHandicapped);
			return ct4;
		}
		
	}
}
