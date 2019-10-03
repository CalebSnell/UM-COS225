import java.util.*;

public class ParkingLot {

    public static void main(String[] args) {
        // Declare objects to use later on
        Scanner scan = new Scanner(System.in);

        // Stack for ally parking
        Stack<Car> parkingSpots = new Stack<Car>();

        // Array for street metered parking
        ArrayList<Car> parkingStreet =  new ArrayList<Car>;

        // Capacity of ally parking
        final int ALLY_CAPACITY = 5;

        // Total cars in ally and street parking
        int allyCounter = 0;
        int streetCounter = 0;

        // While loop that contains entire assignment
        while (scan.hasNext()) {
            // Strings for storing temporary car data
            String license = "NONE";
            String departureTime = "NONE";
            String arrivalTime = "00 00";
            String parkingStatus = "NONE";

            /* Use regex to keep track of parking status */
            // Checks for parking status
            if (scan.hasNext("^([\\s*AD\\s*])")) {
                parkingStatus = scan.next();
            }
            // Checks for license type
            else if (scan.hasNext("(\\s+[A-Z]{2,15}\\s+)")) {
                license = scan.next();
            }
            // Checks for arrival time
            else if (scan.hasNext("\\d{0,2}(\\d{1,2})?")) {
                arrivalTime = scan.nextLine();
            }

            /* Push or pop car depending on parkingStatus */
            if (parkingStatus.equals("A")) {
                if (parkingSpots.size() < ALLY_CAPACITY) {
                    parkingSpots.push(new Car(arrivalTime, departureTime, license));
                } else {
                    System.out.println("No space fuck you go away");
                }
            }
            // Pop cars into metered parking until requested car is found
            else if (parkingStatus.equals("D")) {
                // Loop and compare license to each parked car until found
                while (parkingSpots.peek().compareTo(license) != 1) {
                    parkingStreet.add(parkingSpots.pop());

                }
            }


        }



    }

    public void displayReport(Car car, String fee) {
    }

    public String parkingFee(String arrivalTime, String departureTime) {
        return departureTime;
    }

}



