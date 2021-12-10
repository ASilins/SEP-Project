package Model;
import java.util.ArrayList;

/**
 * A class containing lesson object list
 * @author Arturs Silins and Sid
 * @version 1.0
 */
public class ScheduleSystem
{
  private ArrayList<Lesson> lessons;
  private ClassList classes;

  /**
   * no argument constructor initializing the ScheduleSystem with lessons
   */
  public ScheduleSystem() {
    lessons = new ArrayList<Lesson>();
  }

  /**
   * adds a lesson to the lesson list
   * @param lesson that needs to be added to the list
   */
  public void addLesson(Lesson lesson) {
    if (lessons.isEmpty())
      lessons.add(lesson);
    else
    {
      for (int i=0; i<lessons.size(); i++)
      {
        if (lessons.get(i).isAvailable(lesson))
        {
          lessons.add(lesson);
        }


      }
    }
  }

  /**
   * gets lesson by index
   * @param index the index of the lesson that needs to be returned
   * @return the lesson with that particular index
   */
  public Lesson getLesson(int index) {
    return lessons.get(index);
  }

  /**
   * removes a lesson from the lesson list
   * @param lesson that needs to be removed
   */

  public void removeLesson(Lesson lesson) {
    lessons.remove(lesson);
  }

  /**
   * returns the size of the schedulesystem
   * @return the size of the schedulesystem
   */

  public int size() {
    return lessons.size();
  }

  /**
   * Returns a string representation of the schedule system.
   * @return a string representation of the schedule system in format: "lesson"
   */
  public String toString() {
    String returnString = "";

    for (int i = 0; i < lessons.size(); i++) {
      returnString += lessons.get(i);
    }

    return returnString;
  }
}
