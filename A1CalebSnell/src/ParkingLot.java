// Programmed by Caleb Snell
// Class that defines / implements methods for creating / organizing a parking lot

import java.util.*;

public class ParkingLot {
	private ArrayList<ParkingSpot> parkingSpots;
	
	//-----CONSTRUCTORS-----//
	public ParkingLot () {
		
		// create default parkingSpot to add to ArrayList
		ParkingSpot parkingSpot = new ParkingSpot();
		// create blank parkingSpots ArrayList
		parkingSpots = new ArrayList<ParkingSpot>();
		
		// loop through and create 14 parkingSpots, and then 4 handicap only spots
		for (int ct1 = 0; ct1 < 19; ct1++) {
			parkingSpots.add(parkingSpot);
		}
		for (int ct2 = 0; ct2 < 3; ct2++) {
			parkingSpots.set(ct2, parkingSpot.setHandicappedOnly(true));
		}
		
		
	}
	
}
