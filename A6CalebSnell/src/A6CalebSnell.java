import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A6CalebSnell {
    public static void main(String[] args) throws IOException {
        // Constants
        int alphabetLength = 26;

        // Tree containing characters following morse pattern
        TreeNode<String> morseTree = new TreeNode<String>();

        // Scanner object for scanning in file input
        Scanner fileScan = new Scanner(new FileReader("morsecode.txt"));

        // Arrays for storing alphabet letters and morse encoding
        String[] morseArray = new String[alphabetLength];
        String[] morseChars = new String[alphabetLength];

        // Loop through morse file and get alphabet characters + their respective encoding
        for (int ct1 = 0; ct1 < alphabetLength; ct1++) {
            morseChars[ct1] = fileScan.next();
            morseArray[ct1] = fileScan.nextLine();
        }


    }

    public String insertMorseChar (String morseChar, String morseArray, TreeNode<String> morseTree) {
    // PRE: morseChar == a-z, morseArray (max size of 4) == 'o' or '-'
    // PRE: morseTree already has empty root
    // POST: Inserts alphabet character to tree based off morse code

        // Loop for number of morse characters
        for (int ct1 = 0; ct1 < morseArray.length(); ct1++){
            if (morseArray.charAt(ct1) == 'o') {
                morseTree.g
            }
        }


    }

}
