// An extension of the previous assignment, A6CalebSnell. This adds a few more functions.
// These functions include morse to english, english to morse, and a search function.
// Both TreeNode and the main class were reused.
// Programemed by Caleb Snell

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A7CalebSnell {
    public static void main(String[] args) throws IOException {
        // Tree containing characters following morse pattern
        TreeNode<Character> morseRoot = new TreeNode<>();

        // Scanner object for scanning morse code data from file
        Scanner fileScan = new Scanner(new FileReader("morsecode.txt"));
        // Scanner object for scanning user input
        Scanner kbScan = new Scanner(System.in).useDelimiter("\\n");

        // Loop through morse file and get alphabet characters + their respective encoding
        while (fileScan.hasNext()) {

            // Scan in first line of morse code data without spaces
            String temp = fileScan.nextLine();
            temp = temp.replaceAll("\\s", "");
            Character data = temp.charAt(0);

            // Create curNode for storing current node (starts at morseRoot)
            TreeNode<Character> curNode = morseRoot;

            //  Loop through tree n times, where N is length of temp
            for (int ct1 = 1; ct1 < temp.length() - 1; ct1++) {
                // Set curNode to next left descendant is morse data is 'o'
                if (temp.charAt(ct1) == ('o')) {
                    curNode = curNode.getLeft();
                }
                // else ('-') set curNode to right descendant
                else {
                    curNode = curNode.getRight();
                }
            }

            // if last morse code data is 'o'
            if (temp.charAt(temp.length() - 1) == 'o') {
                curNode.insertLeft(data);
            }
            // if last code data is '-'
            else {
                curNode.insertRight(data);
            }
        }

        // User menu choice
        String menuChoice = "";
        // Get menu choice from user
        while (!menuChoice.equals("Q")) {

            // Prompt user for menu input
            System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%n", "Pre: Print tree in preorder",
                    "Post: Print tree in postorder", "T: Convert English to morse code",
                    "R: Convert morse code to English", "Q. Exit Program");
            System.out.printf("%s", "Please enter your choice: ");

            // get next operation from user
            menuChoice = kbScan.next().toLowerCase();

            // print tree in preorder
            if (menuChoice.contentEquals("pre")) {
                morseRoot.preorder(morseRoot);
            }
            // print tree in postorder
            else if (menuChoice.contentEquals("post")) {
                morseRoot.postorder(morseRoot);
            }
            // translate to morse
            else if (menuChoice.contentEquals("t")) {
                StringBuilder morseCode = new StringBuilder();
                String key;

                // Ask user for morse conversion string
                System.out.printf("%n%s", "Please enter the string to be converted to morse: ");
                // Convert to lower case and strip spaces for matching
                key = kbScan.next().toLowerCase().replaceAll("\\s+", "");

                // Loop through entire key string until morse code is printed.
                System.out.printf("%n%s","Morse code: ");
                for (int ct1 = 0; ct1 < key.length(); ct1++) {
                    morseRoot.char2morse(key.charAt(ct1), morseCode);
                }
                System.out.println();
            }
            // translate from morse to string
            else if (menuChoice.contentEquals("r")) {

                // Ask user for conversion string
                System.out.printf("%n%s", "Please enter the string to be converted to English: ");
                // Add morse code segments to array
                String temp = kbScan.next();
                temp = temp.replaceAll("\\s+", "");
                String[] morseCode = temp.split("\\|");

                // Process and print morse code segments into English
                System.out.printf("%n%s","English: ");
                for (String s : morseCode) {
                    System.out.print(morseRoot.morse2char(s));
                }
                System.out.println();
            }
            // Catch invalid menu option
            else {
                System.out.println("Invalid menu item");
            }
        }
        // Exit gracefully when Q is pressed
        System.exit(0);
    }
}
