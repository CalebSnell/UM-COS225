abstract class Car implements Comparable{
    private String cLicense;
    private String cArrivalTime;

    //-----CONSTRUCTORS-----//
    public Car() {
        // POST: create default Car with placeholder values
        cLicense = "GUEST";
        cArrivalTime = "00 00";
    }

    public Car(String arrivalTime, String license) {
        // POST: creates Car with given information
        cLicense = license;
        cArrivalTime = arrivalTime;
    }

    //-----MODIFIERS-----//
    public void setArrivalTime (String arrivalTime) {
        // POST: set arrival time to provided data
        cArrivalTime = arrivalTime;
    }
    public void setLicense (String license) {
        // POST: set license to provided data
        cLicense = license;
    }

    //------ACCESSORS------//
    public String getArrivalTime() {
        // POST: returns arrival time
        return cArrivalTime;
    }
    public String getLicense() {
        // POST: returns license
        return cLicense;
    }

    public String toString() {
        // POST: returns all car info concatenated into a string
        return(cArrivalTime + cLicense);
    }

    public int compareTo(String license) {
        // POST: return 1 if given license is equal to stored license
        if (license == cLicense) {
            return 1;
        }
        else {
            return 0;
        }

    }
}
