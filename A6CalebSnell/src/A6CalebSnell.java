// Organizes morse code data into a tree. Data comes from morsecode.txt
// Programmed by Caleb Snell

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A6CalebSnell {
    public static void main(String[] args) throws IOException {

        // Tree containing characters following morse pattern
        TreeNode<String> morseRoot = new TreeNode<String>();

        // Scanner object for scanning morse code data
        Scanner fileScan = new Scanner(new FileReader("morsecode.txt"));

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

        // Close scanner
        fileScan.close();

        // Print Z from tree
        System.out.printf("%s%s%n", "Print Z from tree: ", morseRoot.getRight()
                .getRight().getLeft().getLeft().getElement().toString());

        // Print Q from tree
        System.out.printf("%s%s%n", "Print Q from tree: ", morseRoot.getRight()
                .getRight().getLeft().getRight().getElement().toString());

        // Print R from tree
        System.out.printf("%s%s%n", "Print R from tree: ", morseRoot.getLeft()
                .getRight().getLeft().getElement().toString());
    }

}
