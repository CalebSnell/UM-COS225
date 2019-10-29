// Stores, displays, modifies, and runs calculations on, student information.
// Programmed by Caleb Snell

import java.util.*;

public class main {

    public static void main(String[] args) {
        // Create keyboard input scanner
        Scanner kbScan = new Scanner(System.in);

        // Linked list of students
        LinkedList<Student> studentDB = new LinkedList<Student>();

        // char of user choice
        char menuChoice = ' ';

        // Const of max classes
        final int CLASS_CAPACITY = 5;

        // Determine if user wants to quit
        while (menuChoice != 'Q') {

            // Prompt user for menu input
            System.out.printf("%n%s%n%s%n%s%n%s%n%n", "A. Add a student",
                    "B. Delete a student", "C. Display a student", "D. Print average");
            System.out.printf("%s", "Please enter your choice: ");

            // get next operation from user
            menuChoice = kbScan.next().charAt(0);

            // Add student
            if (menuChoice == 'A') {
                // Temp student info
                String name;
                int year;
                LinkedList<String> classes = new LinkedList<String>();
                ArrayList<Integer> grades = new ArrayList<Integer>();


                // Prompt user for student name and year
                System.out.printf("%n%s%n", "Please enter the student's name followed by a space and their academic year.");
                name = kbScan.next();
                year = kbScan.nextInt();

                // Prompt user for student classes
                System.out.printf("%n%s%n", "Please enter the student's classes with each separated by a space.");
                for (int ct1 = 0; ct1 < CLASS_CAPACITY; ct1++) {
                    classes.insert(kbScan.next());
                }

                // Prompt user for student grades
                System.out.printf("%n%s%n", "Please enter the student's grades with each separated by a space.");
                for (int ct1 = 0; ct1 < CLASS_CAPACITY; ct1++) {
                    grades.add(kbScan.nextInt());
                }

                // Store provided data in temp student, then insert student into linked list
                Student student = new Student(name, year, classes, grades);
                studentDB.insert(student);
            }
            // Delete student
            else if (menuChoice == 'B') {

                // Index of student to be removed
                int studentIndex;

                // Prompt user for index of desired student
                System.out.printf("%n%s%n", "Please enter the index of which student you'd like to remove");
                studentIndex = kbScan.nextInt();

                // Remove student
                studentDB.remove(studentIndex);
            } else if (menuChoice == 'C') {
                // Index of student to be displayed
                int studentIndex;

                // Prompt user for index of desired student
                System.out.printf("%n%s%n", "Please enter the index of which student you'd like to display");
                studentIndex = kbScan.nextInt();

                // Display student
                System.out.println(studentDB.get(studentIndex).toString());
            } else if (menuChoice == 'D') {

                // Index of grades to average
                int gradeIndex;

                // Prompt user for index of desired grades
                System.out.printf("%n%s%n", "Please enter the index of which grades you'd like to average");
                gradeIndex = kbScan.nextInt();

                // Running average of student grades
                double gradeAvg = 0.0;

                // Catch index 0, compute average for first grade in list
                if (gradeIndex == 0) {
                    for (int ct3 = 0; ct3 < studentDB.size(); ct3++)
                        gradeAvg = gradeAvg + studentDB.get(ct3).getGrades().get(0);
                } else {
                    // Loop through grades of specified index and compute total
                    for (int ct4 = 0; ct4 < studentDB.size(); ct4++) {
                        gradeAvg = gradeAvg + studentDB.get(ct4).getGrades().get(gradeIndex);
                    }
                }


                System.out.printf("%n%s%n", "Average: " + gradeAvg / studentDB.size());
            } else {
                System.out.printf("%n%s", "Invalid menu option.");
            }
        }
    }
}

