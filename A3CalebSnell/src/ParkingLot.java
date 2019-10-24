// Program that takes parking lot ingress/egress reports and
// simulates what that would be like at the Stack level.
// Program will report logs for each parking lot transaction,
// and then report the daily totals.

// Programmed by Caleb Snell

import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

public class ParkingLot {

    public static void main(String[] args) throws IOException {

        // Constants
        final int ALLY_CAPACITY = 5;
        final double PARKING_FEE_HOURLY = 5.00;
        final double METER_FEE = 0.50;

        // Scanner object for scanning in file input
        Scanner fileScan = new Scanner(new FileReader("lot.txt"));

        // Stack for ally parking
        Stack<Car> parkingSpots = new Stack<Car>();

        // Array for street metered parking
        Stack<Car> parkingStreet =  new Stack<Car>();

        // Objects for storing info about lot / street
        int allyCounter = 0;
        int streetCounter = 0;
        double streetMeterFees = 0;
        double totalParkingFees = 0;

        // Declare default parking data
        String license = "NONE";
        String parkingStatus = "NONE";
        double parkingFee;
        int timeMin = 00;
        int timeHour = 00;

        // While loop that contains entire assignment
        while (fileScan.hasNext() && !license.equalsIgnoreCase("THIEF")) {

            // Scan data from input file, store into temp objects
            parkingStatus = fileScan.next();
            license = fileScan.next();
            timeHour = fileScan.nextInt();
            timeMin = fileScan.nextInt();

            // Push or pop car depending on parkingStatus
            if (parkingStatus.equals("A")) {
                if (allyCounter < ALLY_CAPACITY) {

                    // Push car into parkingSpots Stack
                    parkingSpots.push(new Car(LocalTime.of(timeHour, timeMin), license));

                    // Increment number of cars in ally, and print report
                    allyCounter++;
                    System.out.printf("%s%s%s%n", license, " parked at ", parkingSpots.peek().getArrivalTime());
                }
                // Report that lot is full
                else {
                    System.out.printf("%s%s%s%s%n", license, " turned away at  ",
                            LocalTime.of(timeHour, timeMin), " - LOT IS FULL!");
                }
            }
            // Pop cars into metered parking until requested car is found
            else if (parkingStatus.equals("D") && !license.equalsIgnoreCase("thief")) {

                // Loop and compare license to each parked car until found
                while (parkingSpots.peek().compareTo(license) != 1) {
                    parkingStreet.add(parkingSpots.pop());
                    allyCounter--;

                    // Calculate meter fees
                    streetMeterFees = streetMeterFees + METER_FEE;
                }
                // Display departure report
                System.out.printf("%s%s%s%s%s%n", parkingSpots.peek().getLicense(), " left at ",
                        LocalTime.of(timeHour, timeMin), " paying $",
                        parkingFee(parkingSpots.peek().getArrivalTime(),
                                LocalTime.of(timeHour, timeMin), PARKING_FEE_HOURLY));

                // Calculate total parking fees before car is removed
                totalParkingFees = totalParkingFees + parkingFee(parkingSpots.peek().getArrivalTime(),
                        LocalTime.of(timeHour, timeMin), PARKING_FEE_HOURLY);
                // Remove requested car
                parkingSpots.pop();
                allyCounter--;

                // Loop until metered street is empty
                while (!parkingStreet.isEmpty()) {
                    parkingSpots.push(parkingStreet.pop());
                    allyCounter++;
                }
            } else {
                System.out.println("Invalid parking status (e.g A/D) " +
                        "or license not found (current license: " + license + ")");
            }
        }

        // Display daily report of parking income and meter fees
        System.out.printf("%n%s%s%n%s%s%n", "Total meter fees: $",
                streetMeterFees, "Total parking fees: $", totalParkingFees);
    }

    public static double parkingFee(LocalTime arrivalTime, LocalTime departureTime, final double HOURLY_FEE) {
        // POST: Return parking fee based off arrival, departure time, and constant hourly rate

        // Calculate number of whole hours parked
        int hoursParked = departureTime.getHour() - arrivalTime.getHour();

        // Determine if partial hour, round up if so.
        if (departureTime.getMinute() - arrivalTime.getMinute() > 0) {
            hoursParked++;
        }

        // return parking fee
        return hoursParked * HOURLY_FEE;
    }

}



