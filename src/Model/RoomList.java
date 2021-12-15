package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing list of room objects.
 * @author Arturs Silins
 * @version 1.3
 */
public class RoomList implements Serializable
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

    if (!check(room))
    {
      rooms.add(room);
    }
  }

  /**
   * Get the room by index from room list.
   * @param index the index of the room in room list
   * @return the room object from room list
   */
  public Room get(int index) {
    return rooms.get(index);
  }

  /**
   * Remove the room from the room list
   * @param room the room to remove from the list
   */
  public void removeRoom(Room room) {
    rooms.remove(room);
  }

  /**
   * Get the room list size.
   * @return the room list size
   */
  public int size() {
    return rooms.size();
  }

  /**
   * Check if the object is in the object list.
   * @param room an object that will be checked in the list
   * @return true if the object is in the list
   */
  public boolean check(Room room) {
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i).equals(room)) {
        return true;
      }
    }

    return false;
  }

  /**
   * returns a room from the room list that room1 can be combined with
   * @param room1 room that needs to be combined with another room
   * @return room that room1 can be combined with
   */
  public Room partnerRoom(Room room1)
  { Room room2= null;
    for (int i =0; i<rooms.size(); i++)
    {
      if (rooms.get(i).getRoomNumber().charAt(1)==room1.getRoomNumber().charAt(1) &&
              rooms.get(i).getRoomNumber().charAt(0)==room1.getRoomNumber().charAt(0) &&
              rooms.get(i).getRoomNumber().charAt(2)!=room1.getRoomNumber().charAt(2))
      {
         room2 =rooms.get(i);
      }
    }
    return room2;
  }

  /**
   * Returns a string representation of the room list.
   * @return a string representation of the room list in format: "Room"
   */
  public String toString() {
    String returnString = "";

    for (int i = 0; i < rooms.size(); i++) {
      returnString += rooms.get(i);
    }

    return returnString;
  }
}
