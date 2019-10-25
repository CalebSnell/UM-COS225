import java.util.ArrayList;

public class Student {
    // Private student info
    private String cName;
    private int cYear;
    private LinkedList<String> cClasses;
    private ArrayList<Integer> cGrades;

    //-----CONSTRUCTORS-----//
    public Student(String name, int year, LinkedList<String> classes, ArrayList<Integer> grades) {
        // POST: Create student with given parameters
        setName(name);
        setYear(year);
        setClasses(classes);
        setGrades(grades);
    }

    //-----MODIFIERS-----//
    public void setName(String name) {
        this.cName = name;
    }

    public void setYear(int year) {
        this.cYear = year;
    }

    public void setClasses(LinkedList<String> classes) {
        this.cClasses = classes;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.cGrades = grades;
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
}
