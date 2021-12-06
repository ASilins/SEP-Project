package Model;
import java.util.ArrayList;


/**
 * A class containing  list of class objects
 * @author Sid
 * @version 1.0
 */
public class ClassList {
    private ArrayList<Class> classes;

    /**
     * No-argument constructor initializing class list.
     */

    public ClassList()
    {
        classes = new ArrayList<Class>();

    }

    /**
     * adds a class to the class list.
     * @param classObject a class that needs to be added to the class list.
     */
    public void addClass(Class classObject)
    {
        classes.add(classObject);
    }

    /**
     * removes a class from the class list
     * @param classObject a class that needs to be removed from the class list
     */
    public void removeClass(Class classObject)
    {
        classes.remove(classObject);

    }

    /**
     * a method that returns a string representation of the class list.
     * @return a string representation of the class list in format: "Class"
     */
    public String toString()
    {
        String returnString ="";
        for (int i=0; i<classes.size(); i++)
        {
            returnString += classes.get(i);
        }
        return returnString;
    }


}
