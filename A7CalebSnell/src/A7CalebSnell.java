// An extension of the previous assignment, A6CalebSnell. This adds a few more functions.
// These functions include morse to english, english to morse, and a search function.
// Both TreeNode and the main class were reused.
// Programemed by Caleb Snell

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class A7CalebSnell {
    public static void main(String[] args) throws IOException {
        // Tree containing characters following morse pattern
        TreeNode<Character> morseRoot = new TreeNode<Character>();

        // Scanner object for scanning morse code data
        Scanner fileScan = new Scanner(new FileReader("morsecode.txt"));

        // Scanner object for scanning user input
        Scanner kbScan = new Scanner(System.in).useDelimiter("\\n");
        // Scanner object for scanning user input with pipes
        Scanner kbScanPipe = new Scanner(System.in).useDelimiter("\\|");

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

       /* System.out.println(morseRoot.morse2char("o-o"));
        System.out.println(morseRoot.morse2char("oo-"));

        StringBuilder temp = new StringBuilder();
        morseRoot.char2morse("d", temp);
        temp = new StringBuilder();
        morseRoot.char2morse("j", temp);
        System.out.println(temp);
        //System.out.println(morseRoot.char2morse('d', temp)); */

        // User menu choice
        String menuChoice = "";

        // Get menu choice from user
        while (menuChoice != "Q") {

            // Prompt user for menu input
            System.out.printf("%n%s%n%s%n%s%n%s%s%n%n", "Pre. Add a student",
                    "Post. Delete a student", "T. Display a student",
                    "R. Print average", "Q. Exit Program");
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
                String key = "";

                // Ask user for morse conversion string
                System.out.printf("%n%s%n", "Please enter the string to be converted to morse: ");
                // Convert to lower case and strip spaces for matching
                key = kbScan.next().toLowerCase().replaceAll("\\s+", "");

                // Loop through entire key string until morse code is printed.
                for (int ct1 = 0; ct1 < key.length(); ct1++) {
                    morseRoot.char2morse(key.charAt(ct1), morseCode);
                }
            }
            // translate from morse to string
            else if (menuChoice.contentEquals("r")) {
                ArrayList<String> morseCode = new ArrayList<String>();

                System.out.printf("%n%s", "Please enter the string to be converted to English: ");

                // Add morse code segments to array
                String temp = kbScan.next();
                temp = temp.replaceAll("\\s+", "");
                while (kbScanPipe.hasNext()) {
                    morseCode.add(kbScanPipe.next());
                }

                // Process and print morse code segments into English
                for (int ct3 = 0; ct3 > morseCode.size(); ct3++) {
                    System.out.print(morseRoot.morse2char(morseCode.get(ct3)));
                }
            } else {
                System.out.println("Invalid menu item");
            }
        }

    }
}
