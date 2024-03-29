
public class ParkingSpot {
	
	// Private objects for car and parking spot information
	private boolean cHandicappedOnly;
	private Car cCar;
	
	//-----CONSTRUCTORS-----//
	public ParkingSpot() {
	// POST: create default ParkingSpot with default Car
		cHandicappedOnly = false;
		cCar = new Car();
	}
	
	public ParkingSpot(boolean handicappedOnly) {
	// POST: creates ParkingSpot with given information, also contains default instance of Car
		cHandicappedOnly = handicappedOnly;
		cCar = new Car();
	}
	
	
	//-----MODIFIERS-----//
	public ParkingSpot setCarMake (String make) {
	// POST: set make to provided data
		cCar.setMake(make);
		return null;
	}
	public ParkingSpot setCarModel (String model){
	// POST: set model to provided data
		cCar.setModel(model);
		return null;
	}
	public ParkingSpot setCarColor (String color){
	// POST: set color to provided data
		cCar.setColor(color);
		return null;
	}
	public ParkingSpot setCarIsHandicapped (boolean isHandicapped){
	// POST: set handicapped boolean to provided data 
		cCar.setIsHandicapped(isHandicapped);
		return null;
	}
	public ParkingSpot setHandicappedOnly(boolean handicappedOnly) {
	// POST: set parking spot handicapped status
		cHandicappedOnly = handicappedOnly;
		return null;
	}
	
	
	//------ACCESSORS------//
	public String getCarMake() {
	// POST: returns make
		return cCar.getMake();
	}
	public String getCarModel() {
	// POST: returns model
		return cCar.getModel();
	}
	public String getCarColor() {
	// POST: returns color
		return cCar.getColor();
	}
	public boolean getCarIsHandicapped() {
	// POST: returns handicapped bool
		return cCar.getIsHandicapped();
	}
	public boolean getHandicappedOnly() {
	// POST: returns handicapped only bool
		return cHandicappedOnly;
		
	}
}
