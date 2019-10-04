import java.time.LocalTime;

public class Car<T> implements Comparable<String> {
    // Private data for storing car info
    private String cLicense;
    private LocalTime cArrivalTime;
    private LocalTime cDepartureTime;
    ;
    //-----CONSTRUCTORS-----//
    public Car() {
        // POST: create default Car with placeholder values
        cLicense = "GUEST";
        cArrivalTime = LocalTime.MIN;
        cDepartureTime = LocalTime.MIN;
    }

    public Car(LocalTime arrivalTime, LocalTime departureTime, String license) {
        // POST: creates Car with given information
        cLicense = license;
        cArrivalTime = arrivalTime;
        cDepartureTime = departureTime;
    }

    //-----MODIFIERS-----//
    public void setArrivalTime (LocalTime arrivalTime) {
        // POST: set arrival time to provided data
        cArrivalTime = arrivalTime;
    }

    public void setDepartureTime (LocalTime departureTime) {
        // POST: set departure time to provided data
        cDepartureTime = departureTime;
    }

    public void setLicense (String license) {
        // POST: set license to provided data
        cLicense = license;
    }

    //------ACCESSORS------//
    public LocalTime getArrivalTime() {
        // POST: returns arrival time
        return cArrivalTime;
    }
    public LocalTime getDepartureTime () {
        // POST: returns departure time
        return cDepartureTime;
    }
    public String getLicense() {
        // POST: returns license
        return cLicense;
    }

    public String toString() {
        // POST: returns all car info concatenated into a string
        return(cArrivalTime + "." + cDepartureTime + " " + cLicense);
    }

    @Override
    public int compareTo(String license) {
        // POST: return 1 if given license is equal to stored license
        if (cLicense.equals(license)) {
            return 1;
        }
        else {
            return 0;
        }

    }
}
