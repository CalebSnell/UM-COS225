import java.util.ArrayList;

public class Student {
    // Private student info, including name year, classes, and grades.
    private String cName;
    private int cYear;
    private LinkedList<String> cClasses = new LinkedList<>();
    private ArrayList<Integer> cGrades = new ArrayList<>();

    //-----CONSTRUCTORS-----//
    public Student() {
        setName("NONE");
        setYear(0);
    }

    public Student(String name, int year, LinkedList<String> classes, ArrayList<Integer> grades) {
        // POST: Create student with given parameters
        setName(name);
        setYear(year);
        addClass(classes);
        addGrade(grades);
    }

    //-----MODIFIERS-----//
    public void setName(String name) {
        cName = name;
    }

    public void setYear(int year) {
        cYear = year;
    }

    public void addClass(LinkedList<String> classes) {
        cClasses = classes;
    }

    public void addGrade(ArrayList<Integer> grades) {
        cGrades = grades;
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
        for (int ct1 = 0; ct1 < getGrades().size(); ct1++) {
            average = (average + getGrades().get(ct1));
        }
        return average / getGrades().size();
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

    // Return student information
    public String toString () {
        return String.format("%s%n%s%n%s%n%s", "Name: " + getName(), "Year: " +
                getYear(), "# of Courses: " + getClasses().size(), "Average Grade: "
                + numberToLetterGrade(getAverage()));
    }
}
