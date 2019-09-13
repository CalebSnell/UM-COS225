
public class Car {
	
	// private objects for storing car information
	private String cMake;
	private String cModel;
	private String cColor;
	private boolean cIsHandicapped;
	
	//-----CONSTRUCTORS-----//
	public Car() {
	// POST: create default Car with placeholder values
		cMake = "None";
		cModel = "None";
		cColor = "None";
		cIsHandicapped = false;
	}
	
	public Car(String make, String model, String color, boolean isHandicapped) {
	// POST: creates Car with given information
		cMake = make;
		cModel = model;
		cColor = color;
		cIsHandicapped = isHandicapped;
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
	public String toString() {
	// POST: returns all car info concatenated into a string
		return(cMake + cModel + cColor);
	}
	
}
