// Customer class for COS225 A5. Contains name and zone information
// Programmed by Caleb Snell

public class Customer {

    private String cName;  // customer name
    private String cZone;  // customer zone

    //-----CONSTRUCTORS-----//
    // Default customer constructor
    public Customer() {
        cName = "NONE";
        cZone = "A";
    }
    // Create customer object based off given parameters
    public Customer(String name, String zone) {
        cName = name;
        cZone = zone;
    }

    //-----MODIFIERS-----//
    public void set_cName(String name) {
        cName = name; // assign cName to given name
    }
    public void set_cZone(String zone) {
        cZone = zone; // assign cZone to given zone
    }

    //------ACCESSORS------//
    public String get_cName() {
        return cName;
    }
    public String get_cZone() {
        return cZone;
    }
}
