public class Suite extends Room {

  private boolean spaOrSalon;
  public Suite(int occupants, int days, boolean spaOrSalon) {
    super(2, occupants, days);
    this.spaOrSalon = spaOrSalon; //true if spa reservation, false if salon reservation
  }

  public String toString() {
    return "Suite with a " + (spaOrSalon? "Spa reservation ": "Salon reservation ") + "and " +   super.toString();
  }

  
}