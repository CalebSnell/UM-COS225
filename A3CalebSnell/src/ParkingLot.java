/* Program that takes parking lot ingress/egress reports and
   simulates what that would be like at the Stack level.
   Program will report logs for each parking lot transaction.
*/
// Programmed by Caleb Snell

import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

public class ParkingLot {

    public static void main(String[] args) throws IOException {
        // Scanner object for scanning in file input
        Scanner fileScan = new Scanner(new FileReader("lot.txt"));

        // Stack for ally parking
        Stack<Car> parkingSpots = new Stack<Car>();

        // Array for street metered parking
        Stack<Car> parkingStreet =  new Stack<Car>();

        // Constants
        final int ALLY_CAPACITY = 5;
        final double PARKING_FEE_HOURLY = 5.00;

        // Total cars in ally and street parking
        int allyCounter = 0;
        int streetCounter = 0;

        // While loop that contains entire assignment
        while (fileScan.hasNext()) {
            // Default car data
            String license = "NONE";
            String departureTime = "NONE";
            String arrivalTime = "00 00";
            String parkingStatus = "NONE";

            // Scan data from input file, store into temp objects
            parkingStatus = fileScan.next();
            license = fileScan.next();

            /* Push or pop car depending on parkingStatus */
            if (parkingStatus.equals("A")) {
                if (allyCounter < ALLY_CAPACITY) {
                    // Scan time into arrival time
                    arrivalTime = fileScan.nextLine();
                    parkingSpots.push(new Car(arrivalTime, departureTime, license));
                    allyCounter++;
                } else {
                    System.out.println("No space fuck you go away");
                }
            }
            // Pop cars into metered parking until requested car is found
            else if (parkingStatus.equals("D")) {
                // Scan time into departure time for fee calc
                departureTime = fileScan.nextLine();
                // Loop and compare license to each parked car until found
                while (parkingSpots.peek().compareTo(license) != 1) {
                    parkingStreet.add(parkingSpots.pop());
                    allyCounter--;

                }
                // Remove requested car
                parkingSpots.pop();

                // Loop until metered street is empty
                while (!parkingStreet.isEmpty()) {
                    parkingSpots.push(parkingStreet.pop());
                }

            }
            // Tell the user to give good data if parkingStatus != A||D
            else {
                System.out.println("Incorrect departure / arrival status, please check data");
            }

            System.out.println("One processed you fucking loser");
        }


    }

    public void displayReport(Car car, String fee) {
    }

    public double parkingFee(LocalTime arrivalTime, LocalTime departureTime, final double HOURLY_FEE) {
        double parkingFee = 0;

        // Get number of whole hours parked
        int hoursParked = departureTime.getHour() - arrivalTime.getHour();

        // Determine if partial hour, round up if so.
        if (departureTime.getMinute() - arrivalTime.getMinute() > 0) {
            hoursParked++;
        }

        parkingFee = hoursParked * HOURLY_FEE;
    }

}



