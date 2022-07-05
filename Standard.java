public class Standard extends Room {
  private boolean gymOrBreak;
  
  public Standard(int occupants, int days, boolean gymOrBreak) {
    super(4, occupants, days);
    this.gymOrBreak = gymOrBreak;
  }

  public String toString() {
    return "Standard with " + (gymOrBreak? "Gym Pass ": "Complementary Breakfast ") + "and " + super.toString();
  }
}