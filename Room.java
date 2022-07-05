public class Room {
  private int capacity;
  private int occupants;
  private int days;
  
  public Room(int capacity, int occupants, int days) {
    this.capacity = capacity;
    this.occupants = occupants;
    this.days = days;
  }

  /*
  public boolean filled() {
    return occupants < capacity; //occupants functions as index of array, so need to ad 1 to get the actual number of people in the room
  }
*/
  
  public int getCapacity() {
    return capacity;
  }

  public int getOccupants() {
    return occupants;
  }

  public String toString() {
    return occupants + " guests " + "for " + days + " days ";
  }

  
  /*
  public boolean addPerson(Guest gst) {
    if (!filled()){
      guests[occupants] = gst;
      this.occupants++;
      return true;
    }
    return false;
  }
*/
  /*
  public boolean removeRoommate(Guest gst) {
    if (occupants > 0) {
      for (int idx = 0; idx < guests.length; idx++) {
        if (guests[idx] != null && guests[idx].equals(gst)) {
         return true; 
        }
      }
    }
    return false;
  }*/
}