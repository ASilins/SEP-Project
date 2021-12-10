package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing  list of class objects
 * @author Sid
 * @version 1.0
 */
public class ClassList implements Serializable
{
    private ArrayList<Class> classes;

    /**
     * No-argument constructor initializing class list.
     */
    public ClassList() {
        classes = new ArrayList<Class>();
    }

    /**
     * Adds a class to the class list.
     * @param classObject a class that needs to be added to the class list.
     */
    public void addClass(Class classObject) {
        classes.add(classObject);
    }

    /**
     * Get the class object from class list with index.
     * @param index the index of the class object in list
     * @return the class object
     */
    public Class get(int index) {
        return classes.get(index);
    }

    /**
     * Removes a class from the class list
     * @param classObject a class that needs to be removed from the class list
     */
    public void removeClass(Class classObject) {
        classes.remove(classObject);
    }

    /**
     * Get the size of the class list.
     * @return the size of the class list
     */
    public int size() {
        return classes.size();
    }

    /**
     * A method that returns a string representation of the class list.
     * @return a string representation of the class list in format: "Class"
     */
    public String toString() {
        String returnString = "";

        for (int i=0; i<classes.size(); i++) {
            returnString += classes.get(i);
        }

        return returnString;
    }
}
