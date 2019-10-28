// Stores, displays, modifies, and runs calculations on, student information.
// Programmed by Caleb Snell

import java.util.*;

public class main {

    public static void main(String[] args) {
        // Create keyboard input scanner
        Scanner kbScan = new Scanner(System.in);

        // Linked list of students
        LinkedList<Student> studentDB;

        // char of user choice
        char menuChoice = ' ';

        // Determine if user wants to quit
        while (menuChoice != 'Q') {
            System.out.println("Please enter your choice: ");
            System.out.printf("%n%s%n%s%n%s%n%s", "A. Add a student",
            "B. Delete a student", "C. Display a student", "D. Add grades");

            // get next operation from user
            menuChoice = kbScan.next().charAt(0);
            if (menuChoice == 'A') {
                String name;
                int year;


                //studentDB.insert(Student());
            }
        }

        // Add students to the linked list
        for (int ct1 = 0; ct1 < 4; ct1++) {
        }
    }
}
