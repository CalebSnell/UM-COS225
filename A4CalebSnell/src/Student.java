import java.util.ArrayList;

public class Student {
    // Private student info, including name year, classes, and grades.
    private String cName;
    private int cYear;
    private LinkedList<String> cClasses;
    private ArrayList<Integer> cGrades;

    //-----CONSTRUCTORS-----//
    public Student(String name, int year, String newClass, int newGrade) {
        // POST: Create student with given parameters
        setName(name);
        setYear(year);
        addClass(newClass);
        addGrade(newGrade);
    }

    //-----MODIFIERS-----//
    public void setName(String name) {
        cName = name;
    }

    public void setYear(int year) {
        cYear = year;
    }

    public void addClass(String newClass) {
        cClasses.insert(newClass);
    }

    public void addGrade(int newGrade) {
        cGrades.add(newGrade);
    }

    //------ACCESSORS------//
    public String getName() {
        return cName;
    }

    public int getYear() {
        return cYear;
    }

    public LinkedList<String> getClasses() {
        return cClasses;
    }

    public ArrayList<Integer> getGrades() {
        return cGrades;
    }

    public double getAverage() {
    // POST: returns average between 0 - 100
        double average = 0;
        // loop through grades array list and compute average
        for (int ct1 = 0; ct1 <= getGrades().size(); ct1++) {
            average = average + getGrades().get(ct1);
        }
        return average;
    }

    public char numberToLetterGrade (double average) {
    // PRE: Average must be between 0 and 100
    // POST: Letter grade of A, B, C, D, F
        if (average >= 93) {
            return 'A';
        }
        else if (average >= 80 && average <= 92) {
            return 'B';
        }
        else if (average >= 70 && average <= 79) {
            return 'C';
        }
        else if (average >= 60 && average <= 69) {
            return 'D';
        }
        else {
            return 'F';
        }
    }

    public String toString () {
        return getName() + " " + getYear() + " " + getClasses().size() + " " + getAverage();
    }
}
