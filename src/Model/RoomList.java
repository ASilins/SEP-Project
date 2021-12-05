package Model;

import java.util.ArrayList;

/**
 * A class containing list of room objects.
 * @author Arturs Silins
 * @version 1.0
 */
public class RoomList
{
  private ArrayList<Room> rooms;

  /**
   * No-argument constructor initializing room list.
   */
  public RoomList() {
    rooms = new ArrayList<Room>();
  }

  /**
   * Adds the room to room list.
   * @param room the room to add to room list
   */
  public void addRoom(Room room) {
    rooms.add(room);
  }

  /**
   * Remove the room from the room list
   * @param room the room to remove from the list
   */
  public void removeRoom(Room room) {
    rooms.remove(room);
  }

  /**
   * Returns a string representation of the room list.
   * @return a string representation of the room list in format: "Room"
   */
  public String toString() {
    String returnString = "";

    for (int i = 0; i < rooms.size(); i++) {
      returnString += rooms;
    }

    return returnString;
  }
}
