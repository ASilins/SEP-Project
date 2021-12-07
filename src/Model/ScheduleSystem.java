package Model;

import java.util.ArrayList;

/**
 * A class containing lesson object list
 * @author Arturs Silins
 * @version 1.0
 */
public class ScheduleSystem
{
  private ArrayList<Lesson> lessons;
  private ClassList classes;

  public ScheduleSystem() {
    lessons = new ArrayList<Lesson>();
    classes = new ClassList();
  }

  public void addLesson(Lesson lesson) {
    lessons.add(lesson);
  }

  public Lesson getLesson(int index) {
    return lessons.get(index);
  }

  public void removeLesson(Lesson lesson) {
    lessons.remove(lesson);
  }

  public ClassList getClasses() {
    return classes;
  }

  public int size() {
    return lessons.size();
  }

  public String toString() {
    String returnString = "";

    for (int i = 0; i < lessons.size(); i++) {
      returnString += lessons.get(i);
    }

    return returnString;
  }
}
