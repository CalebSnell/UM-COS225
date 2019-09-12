
public class ParkingSpot {
	
	// Private data for car and parking spot information
	private String cMake;
	private String cModel;
	private String cColor;
	private boolean cIsHandicapped;
	private boolean cHandicappedOnly;
	Car cCar = new Car();
	
	//-----CONSTRUCTORS-----//
	public ParkingSpot() {
	// POST: create default ParkingSpot with placeholder values
		cMake = "None";
		cModel = "None";
		cColor = "None";
		cIsHandicapped = false;
		cHandicappedOnly = false;
	}
	
	public ParkingSpot(String make, String model, String color, boolean isHandicapped, boolean handicappedOnly) {
	// POST: creates ParkingSpot with given information, also contains instance of Car
		cMake = make;
		cModel = model;
		cColor = color;
		cIsHandicapped = isHandicapped;
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
	public void setHandicappedOnly(boolean handicappedOnly) {
		cHandicappedOnly = handicappedOnly;
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
