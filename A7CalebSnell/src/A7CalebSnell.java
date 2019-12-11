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
        TreeNode<String> morseRoot = new TreeNode<String>();

        // Scanner object for scanning morse code data
        Scanner fileScan = new Scanner(new FileReader("morsecode.txt"));

        // Scanner object for scanning user input
        Scanner kbScan = new Scanner(System.in);

        // Loop through morse file and get alphabet characters + their respective encoding
        while (fileScan.hasNext()) {

            // Scan in first line of morse code data without spaces
            String temp = fileScan.nextLine();
            temp = temp.replaceAll("\\s", "");
            String data = Character.toString(temp.charAt(0));

            // Create curNode for storing current node (starts at morseRoot)
            TreeNode<String> curNode = morseRoot;

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

        System.out.println(morseRoot.morse2char("o-o"));
        System.out.println(morseRoot.morse2char("oo-"));

        StringBuilder temp = new StringBuilder();
        morseRoot.char2morse("d", temp);
        temp = new StringBuilder();
        morseRoot.char2morse("j", temp);
        System.out.println(temp);
        //System.out.println(morseRoot.char2morse('d', temp));

        /* User menu choice
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

            if (menuChoice == "pre") {

            }


        }*/

    }
}
