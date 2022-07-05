import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("------------------------------\nWelcome to the CJZ Hotel Database!");
    while (true) {
      System.out.println("\nTo start a hotel reservation type \"start\".\nType \"view\" to view hotel reservations.\nType \"quit\" to quit.");
      String response = scan.nextLine().toLowerCase();
      while (!(response.equals("start") || response.equals("view") || response.equals("quit"))) {
        System.out.println("Type start, view, or quit.");
        response = scan.nextLine().toLowerCase();
      }
      if (response.equals("start")) {
        System.out.println("\nWould you like to purchase a Suite or an Standard room?\n\tThe Suite can hold a maximum of 2 people and comes with the option of free spa or salon reservations.\naThe Standard can hold a maximum of 4 people and comes with the option of a free gym pass or complementary breakfast.\n\nType Suite or Standard");
        String roomType = scan.nextLine().toLowerCase();
        int occupants;
        int days;
        while (!(roomType.equals("suite") || roomType.equals("standard"))) {
            System.out.println("Please enter suite or standard.");
            roomType = scan.nextLine();
        }
        if (roomType.equals("suite")) {
          System.out.println("How many guests will be staying in the room?");
          occupants = scan.nextInt();
          while (occupants > 2 || occupants < 1) {
            System.out.println("That's an incorrect number of guests. Please enter a guest number between 1 and 2");
            occupants = scan.nextInt();
          }
          System.out.println("How many days will you be staying?");
          days = scan.nextInt();
          while (days < 1) {
            System.out.println("That's an incorrect day value. Please input a value greater than or equal to 1.");
            days = scan.nextInt();
          }
          System.out.println("Would you like free reservations at the spa or the salon?\nType spa or salon.");
          String reservation = scan.nextLine();
          reservation = reservation.toLowerCase();
          while (!(reservation.toLowerCase().equals("spa") || reservation.toLowerCase().equals("salon"))) {
            System.out.println("Please enter spa or salon.");
            reservation = scan.nextLine();
            reservation = reservation.toLowerCase();
          }
          boolean spa = reservation.equals("spa")? true: false;
          Suite temp = new Suite(occupants, days, spa);
          try {
            FileWriter fw = new FileWriter(new File("suite.dat"), true);
            fw.write(temp + "\n");
            fw.close();
          } catch (Exception e) {
            System.err.println("There was an error writing to the file " + e.getMessage());
            }
        }
        else if (roomType.equals("standard")) {
          System.out.println("How many guests will be staying in the room?");
          occupants = scan.nextInt();
          while (occupants > 4 || occupants < 1) {
            System.out.println("That's an incorrect number of guests. Please enter a guest number between 1 and 2");
            occupants = scan.nextInt();
          }
          System.out.println("How many days will you be staying?");
          days = scan.nextInt();
          while (days < 1) {
            System.out.println("That's an incorrect day value. Please input a value greater than or equal to 1.");
            days = scan.nextInt();
          }
          System.out.println("Would you like a free gym visit or a complementary breakfast?\nType gym or breakfast.");
          String reservation = scan.nextLine();
          reservation = reservation.toLowerCase();
          while (!(reservation.equals("gym") || reservation.equals("breakfast"))) {
            System.out.println("Please enter gym or breakfast.");
            reservation = scan.nextLine();
            reservation = reservation.toLowerCase();
          }
          boolean gym = reservation.equals("gym")? true: false;
          Standard temp = new Standard(occupants, days, gym);
          try {
            FileWriter fw = new FileWriter(new File("standard.dat"), true);
            fw.write(temp + "\n");
            fw.close();
          } catch (Exception e) {
            System.err.println("There was an error writing to the file " + e.getMessage());
          }
        }
      }
      else if (response.equals("view")) { //opening files
          System.out.println("To view just the suites, type suite. To view just the standard rooms, type standard.");
          String view = scan.nextLine().toLowerCase();
          while (!(view.equals("suite") || view.equals("standard"))) {
            System.out.println("That's an invalid response! Type hotel, suite, or standard.");
            view = scan.nextLine();
          }
          if (view.equals("suite")){
            try {
              Scanner file = new Scanner(new File("suite.dat"));
              while (file.hasNext()) {
                System.out.print(file.nextLine() + "\n");
              }
              file.close();
            } catch(Exception e) {
              System.err.println("There was an error reading the file " + e.getMessage());
            }
            
          }
          else if (view.equals("standard")){
            try {
              Scanner file = new Scanner(new File("standard.dat"));
              while (file.hasNext()) {
                System.out.print(file.nextLine() + "\n");
              }
              file.close();
            } catch(Exception e) {
              System.err.println("There was an error reading the file " + e.getMessage());
            }
          }
        }
      else if (response.equals("quit")) {
        break;
      }
    }
    scan.close();
  }
}