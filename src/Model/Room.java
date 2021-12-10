package Model;
/**
 * A class containing room information.
 * @author Arturs Silins
 * @version 1.0
 */
public class Room
{
  private String roomNumber;
  private int capacity;
  private char block;
  private int floor;
  private boolean availability;

  /**
   * 4 argument constructor setting information for room and availability to true.
   * @param roomNumber the room number
   * @param capacity the capacity of room
   * @param block the block the room is in
   * @param floor the floor the room is in
   */
  public Room(String roomNumber, int capacity, char block, int floor) {
    this.roomNumber = roomNumber;
    this.capacity = capacity;
    this.block = block;
    this.floor = floor;
    availability = true;
  }

  /**
   * Sets the room number.
   * @param roomNumber what the student number will be set to
   */
  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  /**
   * Sets the room capacity.
   * @param capacity what the room capacity will be set to
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Sets the block of the room.
   * @param block what block the room will be set to
   */
  public void setBlock(char block) {
    this.block = block;
  }

  /**
   * Sets the floor of the room.
   * @param floor what the floor of the room will be set to
   */
  public void setFloor(int floor) {
    this.floor = floor;
  }

  /**
   * Gets the room number
   * @return the room number
   */
  public String getRoomNumber() {
    return roomNumber;
  }

  /**
   * Gets the capacity of the room.
   * @return the capacity of room
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Gets the block of the room.
   * @return the block of the room
   */
  public char getBlock() {
    return block;
  }

  /**
   * Gets the floor of the room.
   * @return the floor of the room
   */
  public int getFloor() {
    return floor;
  }

  /**
   * Sets the room availability to false.
   */
  public void bookRoom() {
    availability = false;
  }

  /**
   * Gets the availability of the room.
   * @return the availability of the room
   */
  public boolean isAvailable() {
    return availability;
  }

  /**
   * Sets room availability to true.
   */
  public void unbookRoom() {
    availability = true;
  }

  /**
   * Compares room number, capacity, block, floor and availability of two rooms.
   * @param obj the object to compare with
   * @return true if the given object is equal to this room
   */
  public boolean equals(Object obj) {
    if (!(obj instanceof Room))
    {
      return false;
    }

    Room other = (Room) obj;

    return (roomNumber.equals(other.roomNumber) && capacity == other.capacity
        && block == other.block && floor == other.floor
        && availability == other.availability);
  }

  /**
   * Returns a string representation of the room.
   * @return a string representation of the room in format: "roomNumber,capacity,block,floor,availability"
   */
  public String toString() {
    return roomNumber + "," + capacity + "," + block + "," + floor + "," + availability + "\n";
  }
}
