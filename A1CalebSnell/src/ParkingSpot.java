
public class ParkingSpot {
	
	// Private objects for car and parking spot information
	private String cMake = "None";
	private String cModel = "None";
	private String cColor = "None";
	private boolean cIsHandicapped;
	private boolean cHandicappedOnly;
	private Car cCar;
	
	//-----CONSTRUCTORS-----//
	public ParkingSpot() {
	// POST: create default ParkingSpot with placeholder values
		cIsHandicapped = false;
		cHandicappedOnly = false;
		cCar = new Car(cMake, cModel, cColor, cIsHandicapped);
	}
	
	public ParkingSpot(boolean handicappedOnly) {
	// POST: creates ParkingSpot with given information, also contains instance of Car
		cHandicappedOnly = handicappedOnly;
		cCar = new Car(cMake, cModel, cColor, cIsHandicapped);
	}
	
	
	//-----MODIFIERS-----//
	public void setMake (String make) {
	// POST: set make to provided data
		cMake = make;
	}
	public void setModel (String model){
	// POST: set model to provided data
		cModel = model;
	}
	public void setColor (String color){
	// POST: set color to provided data
		cColor = color;
	}
	public void setIsHandicapped (boolean isHandicapped){
	// POST: set handicapped boolean to provided data
		cIsHandicapped = isHandicapped;
	}
	public ParkingSpot setHandicappedOnly(boolean handicappedOnly) {
		cHandicappedOnly = handicappedOnly;
		return null;
	}
	
	
	//------ACCESSORS------//
	public String getMake() {
	// POST: returns make
			return cMake;
	}
	public String getModel() {
	// POST: returns model
			return cModel;
	}
	public String getColor() {
	// POST: returns color
		return cColor;
	}
	public boolean getIsHandicapped() {
	// POST: returns handicapped bool
		return cIsHandicapped;
	}
	public boolean getHandicappedOnly() {
		return cHandicappedOnly;
		// POST: returns handicapped only bool
	}
}
