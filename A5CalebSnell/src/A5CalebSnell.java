// This program will take a list of customers and organize them
// into their appropriate rows based off their "zone".

// Programmed by Caleb Snell

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A5CalebSnell {
    public static void main(String[] args) throws IOException {
        // Constants for lazy programming
        final int MAX_SEATS_ROW = 4;
        final int MAX_ZONES = 3;

        // LinkedQueues for each zone
        LinkedQueue<Customer> zoneA = new LinkedQueue<Customer>();
        LinkedQueue<Customer> zoneB = new LinkedQueue<Customer>();
        LinkedQueue<Customer> zoneC = new LinkedQueue<Customer>();

        // LinkedQueue for customers waiting to be seated
        LinkedQueue<Customer> customerQueue = new LinkedQueue<Customer>();

        // Scanner object for scanning in file input
        Scanner fileScan = new Scanner(new FileReader("tickets.txt"));

        // Tracking for number of customers
        int customerTotal = 0;

        while (fileScan.hasNext()) {
            // Temp variables for storing customer info
            String tempCustomerName = "NONE";
            String tempCustomerZone = "A";

            // Scan in customer info, create new Customer object
            tempCustomerName = fileScan.next();
            tempCustomerZone = fileScan.next();
            Customer customer = new Customer(tempCustomerName, tempCustomerZone);

            // Enqueue customer into waiting queue
            customerQueue.enqueue(customer);

            // Increment number of customers
            customerTotal++;
        }

        // Close scanner
        fileScan.close();

        // Dequeue customers from waiting queue into their appropriate zone queues
        for (int ct1 = 0; ct1 < customerTotal; ct1++) {
            // Determine customer zone, enqueue appropriately
            if (customerQueue.peek().get_cZone().equalsIgnoreCase("A")) {
                zoneA.enqueue(customerQueue.dequeue());    // enqueue to zoneA
            } else if (customerQueue.peek().get_cZone().equalsIgnoreCase("B")) {
                zoneB.enqueue(customerQueue.dequeue());    // enqueue to zoneB
            } else {
                zoneC.enqueue(customerQueue.dequeue());    // enqueue to zoneC
            }
        }

        // Display customers sitting in zone A
        displayZone(zoneA, MAX_ZONES, MAX_SEATS_ROW, customerTotal);
        System.out.printf("%n%n");

        // Display customers sitting in zone B
        displayZone(zoneB, MAX_ZONES, MAX_SEATS_ROW, customerTotal);
        System.out.printf("%n%n");

        // Display customers sitting in zone C
        displayZone(zoneC, MAX_ZONES, MAX_SEATS_ROW, customerTotal);
        System.out.printf("%n");
    }


    public static void displayZone(LinkedQueue<Customer> lq, int maxZones, int maxSeatsRow, int customerTotal) {
        // POST: Display contents of queue formatted appropriately

        // Temp holding queue
        LinkedQueue<Customer> tempLq = new LinkedQueue<Customer>();

        // Print first row
        for (int ct2 = 0; ct2 < 2; ct2++) {
            if (ct2 == 0) {
                // Print zone header
                if (lq.peek().get_cZone().equalsIgnoreCase("A")) {
                    System.out.print("A: ");
                } else if (lq.peek().get_cZone().equalsIgnoreCase("B")) {
                    System.out.print("B: ");
                } else {
                    System.out.print("C: ");
                }

                // Loop through and print each seat with customer names
                for (int ct3 = 0; ct3 < maxSeatsRow; ct3++) {
                    // Dequeue and print returned element
                    if (lq.peek() != null) {
                        System.out.printf("%-20s   ", lq.peek().get_cName());
                    }
                    // Print empty if current element is empty
                    else {
                        System.out.printf("%-20s   ", "Empty");
                    }

                    // Dequeue into holding queue
                    tempLq.enqueue(lq.dequeue());
                }
            }

            // Prints second row
            else {
                System.out.println();
                // Print zone header
                if (lq.peek().get_cZone().equalsIgnoreCase("A")) {
                    System.out.print("A: ");
                } else if (lq.peek().get_cZone().equalsIgnoreCase("B")) {
                    System.out.print("B: ");
                } else {
                    System.out.print("C: ");
                }

                // Loop through and print each seat with customer name
                for (int ct3 = 0; ct3 < maxSeatsRow; ct3++) {
                    // Dequeue and print returned element
                    if (lq.peek() != null) {
                        System.out.printf("%-20s   ", lq.peek().get_cName());
                    }
                    // Print empty if current element is empty
                    else {
                        System.out.printf("%-20s   ", "Empty");
                    }

                    // dq into holding queue
                    tempLq.enqueue(lq.dequeue());
                }
            }
        }

        // Move customers from temp queue to original queue
        for (int ct4 = 0; ct4 < customerTotal; ct4++) {
            lq.enqueue(tempLq.dequeue());
        }


    }
}

