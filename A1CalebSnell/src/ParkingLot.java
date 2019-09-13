// Programmed by Caleb Snell
// Class that defines / implements methods for creating / organizing a parking lot

import java.util.*;

public class ParkingLot {
	
	// Private ArrayList of type parkingSpots for storing parking spots
	private ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	// create default parkingSpot object
	public ParkingSpot parkingSpot;
			
	//-----CONSTRUCTORS-----//
	public ParkingLot () {
		
		// loop through and create 20 default parkingSpots
		for (int ct1 = 0; ct1 <= 19; ct1++) {
			parkingSpots.add(new ParkingSpot());
		}
		// set 4 parkingSpots to be handicapped only
		for (int ct2 = 0; ct2 <= 3; ct2++) {
			parkingSpots.get(ct2).setHandicappedOnly(true);
		}
	}

	//-----MODIFIERS-----//
	public int addCar (String make, String model, String color, boolean isHandicapped, int carPos) {
	// POST: Add Car to first available spot depending on handicap status	
		if (isHandicapped) {
			int ct3 = 0;
			// only loops while current spot has a car, and isn't handicap accessible
			while(!parkingSpots.get(ct3).getCarMake().equals("None") || !parkingSpots.get(ct3).getHandicappedOnly()) {
				ct3++;
				if(ct3 >= 20) {
					return -1;
				}
			}
			// set car values based off given data
			parkingSpots.get(ct3).setCarMake(make);
			parkingSpots.get(ct3).setCarModel(model);
			parkingSpots.get(ct3).setCarColor(color);
			parkingSpots.get(ct3).setCarIsHandicapped(isHandicapped);
			// return index of car
			carPos = ct3;
			return carPos;
		}
		else {
			int ct4 = 0;
			// only loops while current spot is not empty OR is handicap only
			while(!parkingSpots.get(ct4).getCarMake().equals("None") || parkingSpots.get(ct4).getHandicappedOnly()) {
				ct4++;
				if(ct4 >= 20) {
					return -1;
				}
			}
			// set car values based off given data
			parkingSpots.get(ct4).setCarMake(make);
			parkingSpots.get(ct4).setCarModel(model);
			parkingSpots.get(ct4).setCarColor(color);
			parkingSpots.get(ct4).setCarIsHandicapped(isHandicapped);
			// return index of car
			carPos = ct4;
			return carPos;
		}
		
	}
	
	public int deleteCar (int carIndex) {
		return carIndex;
		// TODO	
		}
	
	//------ACCESSORS------//
	public String toString() {
	// POST: returns all car info concatenated into a string
		int availHandicapSpots = 0;
		int availStandardSpots = 0;
		
		// counts available handicap and standard spots
		for (int ct5 = 0; ct5 < 19; ct5++) {
			if (parkingSpots.get(ct5).getHandicappedOnly() && parkingSpots.get(ct5).getCarMake().equals("None")) {
				availHandicapSpots++;
			}
			else if (parkingSpots.get(ct5).getCarMake().equals("None") && !parkingSpots.get(ct5).getHandicappedOnly()){
				availStandardSpots++;
			}
		}
		// returns available handicap and standard spots separated by a space
		String availSpots = Integer.toString(availHandicapSpots) + " " + Integer.toString(availStandardSpots);
		return availSpots;
	}
}
